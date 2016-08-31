package com.dci.intellij.dbn.editor.data.filter;

import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.common.ui.Presentable;

public enum DatasetFilterType implements Presentable{
    NONE("None", Icons.DATASET_FILTER_EMPTY, Icons.DATASET_FILTER_EMPTY),
    BASIC("Basic", Icons.DATASET_FILTER_BASIC, Icons.DATASET_FILTER_BASIC_ERR),
    CUSTOM("Custom", Icons.DATASET_FILTER_CUSTOM, Icons.DATASET_FILTER_CUSTOM_ERR),
    GLOBAL("Global", Icons.DATASET_FILTER_GLOBAL, Icons.DATASET_FILTER_GLOBAL_ERR);

    private String name;
    private Icon icon;
    private Icon errIcon;

    DatasetFilterType(String name, Icon icon, Icon errIcon) {
        this.name = name;
        this.icon = icon;
        this.errIcon = errIcon;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Nullable
    public Icon getIcon() {
        return icon;
    }

    public Icon getErrIcon() {
        return errIcon;
    }

    public static DatasetFilterType get(String name) {
        for (DatasetFilterType datasetFilterType : DatasetFilterType.values()) {
            if (datasetFilterType.name.equals(name) || datasetFilterType.name().equals(name)) {
                return datasetFilterType;
            }
        }
        return null;
    }
}
