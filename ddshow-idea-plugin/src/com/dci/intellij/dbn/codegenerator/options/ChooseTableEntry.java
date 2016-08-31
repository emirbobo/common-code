package com.dci.intellij.dbn.codegenerator.options;

import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.common.ui.list.Selectable;

import javax.swing.*;

/**
 * Created by xijingbo on 2016-02-24.
 */
public class ChooseTableEntry implements Selectable<ChooseTableEntry> {
    String tableName;
    boolean enable;

    public ChooseTableEntry(String tableName) {
        this.tableName = tableName;
    }

    public ChooseTableEntry(boolean enable, String tableName) {
        this.enable = enable;
        this.tableName = tableName;
    }

    @Override
    public Icon getIcon() {
        return Icons.DBO_COLUMN;
    }

    @Override
    public String getName() {
        return tableName;
    }

    @Override
    public String getError() {
        return "";
    }

    @Override
    public boolean isSelected() {
        return enable;
    }

    @Override
    public boolean isMasterSelected() {
        return true;
    }

    @Override
    public void setSelected(boolean selected) {
        enable = selected;
    }
    @Override
    public int compareTo(ChooseTableEntry o) {
        return 0;
    }
}
