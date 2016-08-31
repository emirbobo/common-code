package com.dci.intellij.dbn.editor.data.filter.action;

import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.editor.data.filter.DatasetFilter;
import com.dci.intellij.dbn.editor.data.filter.ui.DatasetFilterList;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class MoveFilterUpAction extends AbstractFilterListAction {

    public MoveFilterUpAction(DatasetFilterList filterList) {
        super(filterList, "Move selection up", Icons.ACTION_MOVE_UP);
    }

    public void actionPerformed(AnActionEvent e) {
        DatasetFilterList filterList = getFilterList();
        DatasetFilter filter = (DatasetFilter) filterList.getSelectedValue();
        getFilterGroup().moveFilterUp(filter);
        filterList.setSelectedIndex(filterList.getSelectedIndex()-1);
    }

    @Override
    public void update(AnActionEvent e) {
        int[] index = getFilterList().getSelectedIndices();
        e.getPresentation().setEnabled(index.length == 1 && index[0] > 0);
    }
}