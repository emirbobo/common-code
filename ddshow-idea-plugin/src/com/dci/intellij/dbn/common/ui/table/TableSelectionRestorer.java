package com.dci.intellij.dbn.common.ui.table;

public interface TableSelectionRestorer {
    void snapshot();
    void restore();
    boolean isRestoring();
}
