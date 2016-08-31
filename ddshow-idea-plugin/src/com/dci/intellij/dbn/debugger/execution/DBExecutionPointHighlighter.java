package com.dci.intellij.dbn.debugger.execution;

import com.dci.intellij.dbn.common.thread.ConditionalLaterInvocator;
import com.dci.intellij.dbn.common.util.DocumentUtil;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.ui.DebuggerColors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DBExecutionPointHighlighter {
    private final Project project;
    private RangeHighlighter rangeHighlighter;
    private Editor editor;
    private XSourcePosition sourcePosition;
    private OpenFileDescriptor myOpenFileDescriptor;
    private boolean myUseSelection;

    public DBExecutionPointHighlighter(final Project project) {
        this.project = project;
    }

    public void show(final @NotNull XSourcePosition position, final boolean useSelection) {
        new ConditionalLaterInvocator() {
            public void execute() {
                doShow(position, useSelection);
            }
        }.start();
    }

    public void hide() {
        new ConditionalLaterInvocator() {
            public void execute() {
                doHide();
            }
        }.start();
    }

    public void navigateTo() {
        if (myOpenFileDescriptor != null) {
            FileEditorManager.getInstance(project).openTextEditor(myOpenFileDescriptor, false);
        }
    }

    @Nullable
    public VirtualFile getCurrentFile() {
        return myOpenFileDescriptor != null ? myOpenFileDescriptor.getFile() : null;
    }

    public void update() {
        show(sourcePosition, myUseSelection);
    }

    private void doShow(@NotNull XSourcePosition position, final boolean useSelection) {
        ApplicationManager.getApplication().assertIsDispatchThread();
        removeHighlighter();

        sourcePosition = position;
        editor = openEditor();
        myUseSelection = useSelection;
        if (editor != null) {
            addHighlighter();
        }
    }

    @Nullable
    private Editor openEditor() {
        VirtualFile file = sourcePosition.getFile();
        Document document = DocumentUtil.getDocument(file);
        int offset = sourcePosition.getOffset();
        if (offset < 0 || offset >= document.getTextLength()) {
            myOpenFileDescriptor = new OpenFileDescriptor(project, file, sourcePosition.getLine(), 0);
        } else {
            myOpenFileDescriptor = new OpenFileDescriptor(project, file, offset);
        }
        return FileEditorManager.getInstance(project).openTextEditor(myOpenFileDescriptor, false);
    }

    private void doHide() {
        ApplicationManager.getApplication().assertIsDispatchThread();
        removeHighlighter();
        myOpenFileDescriptor = null;
        editor = null;
    }

    private void removeHighlighter() {
        if (myUseSelection && editor != null) {
            editor.getSelectionModel().removeSelection();
        }
        if (rangeHighlighter == null || editor == null) return;

        editor.getMarkupModel().removeHighlighter(rangeHighlighter);
        rangeHighlighter = null;
    }

    private void addHighlighter() {
        int line = sourcePosition.getLine();
        Document document = editor.getDocument();
        if (line >= document.getLineCount()) return;

        if (myUseSelection) {
            editor.getSelectionModel().setSelection(document.getLineStartOffset(line), document.getLineEndOffset(line) + document.getLineSeparatorLength(line));
            return;
        }

        if (rangeHighlighter != null) return;

        EditorColorsScheme scheme = EditorColorsManager.getInstance().getGlobalScheme();
        rangeHighlighter = editor.getMarkupModel().addLineHighlighter(line, DebuggerColors.EXECUTION_LINE_HIGHLIGHTERLAYER,
                scheme.getAttributes(DebuggerColors.EXECUTIONPOINT_ATTRIBUTES));
    }
}
