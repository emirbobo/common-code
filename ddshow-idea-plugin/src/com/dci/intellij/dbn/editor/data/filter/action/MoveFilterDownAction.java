package com.dci.intellij.dbn.editor.data.filter.action;

import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.editor.data.filter.DatasetFilter;
import com.dci.intellij.dbn.editor.data.filter.ui.DatasetFilterList;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class MoveFilterDownAction extends AbstractFilterListAction {

    public MoveFilterDownAction(DatasetFilterList filterList) {
        super(filterList, "Move selection down", Icons.ACTION_MOVE_DOWN);
    }

    public void actionPerformed(AnActionEvent e) {
        DatasetFilterList filterList = getFilterList();
        DatasetFilter filter = (DatasetFilter) filterList.getSelectedValue();
        getFilterGroup().moveFilterDown(filter);
        filterList.setSelectedIndex(filterList.getSelectedIndex()+1);
    }

    @Override
    public void update(AnActionEvent e) {
        DatasetFilterList filterList = getFilterList();
        int[] index = filterList.getSelectedIndices();
        e.getPresentation().setEnabled(index.length == 1 && index[0] < filterList.getModel().getSize()-1);
    }
}
