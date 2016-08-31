package com.dci.intellij.dbn.ddl.ui;

import javax.swing.JList;

import com.dci.intellij.dbn.ddl.DDLFileNameProvider;
import com.intellij.ui.ColoredListCellRenderer;
import com.intellij.ui.SimpleTextAttributes;

public class DDLFileNameListCellRenderer extends ColoredListCellRenderer {
    protected void customizeCellRenderer(JList list, Object value, int index, boolean selected, boolean hasFocus) {
        DDLFileNameProvider fileNameProvider = (DDLFileNameProvider) value;

        append(fileNameProvider.getFileName(), SimpleTextAttributes.REGULAR_ATTRIBUTES);
        append(" (" + fileNameProvider.getDdlFileType().getDescription() + ") ", SimpleTextAttributes.GRAY_ATTRIBUTES);

        //Module module = ProjectRootManager.getInstance(psiFile.getProject()).getFileIndex().getModuleForFile(virtualFile);
        //append(" - module " + module.getName(), SimpleTextAttributes.GRAYED_ATTRIBUTES);

        setIcon(fileNameProvider.getDdlFileType().getLanguageFileType().getIcon());
    }
}