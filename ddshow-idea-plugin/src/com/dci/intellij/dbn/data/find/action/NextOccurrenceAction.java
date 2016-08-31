package com.dci.intellij.dbn.data.find.action;

import com.dci.intellij.dbn.data.find.DataSearchComponent;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.actionSystem.KeyboardShortcut;
import com.intellij.openapi.actionSystem.Shortcut;
import com.intellij.openapi.project.DumbAware;
import com.intellij.util.containers.ContainerUtil;

import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class NextOccurrenceAction extends DataSearchHeaderAction implements DumbAware {

    public NextOccurrenceAction(DataSearchComponent searchComponent, JComponent component, boolean isSearchComponent) {
        super(searchComponent);

        copyFrom(ActionManager.getInstance().getAction(IdeActions.ACTION_NEXT_OCCURENCE));
        Set<Shortcut> shortcuts = new HashSet<Shortcut>();
        ContainerUtil.addAll(shortcuts, ActionManager.getInstance().getAction(IdeActions.ACTION_FIND_NEXT).getShortcutSet().getShortcuts());

        if (isSearchComponent) {
            ContainerUtil.addAll(shortcuts, ActionManager.getInstance().getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_DOWN).getShortcutSet().getShortcuts());
            shortcuts.add(new KeyboardShortcut(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), null));
        }
        registerShortcutsToComponent(shortcuts, this, component);
    }

    @Override
    public void actionPerformed(final AnActionEvent e) {
        getSearchComponent().searchForward();
    }

    @Override
    public void update(final AnActionEvent e) {
        e.getPresentation().setEnabled(getSearchComponent().hasMatches());
    }
}
