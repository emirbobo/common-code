package com.dci.intellij.dbn.editor.session;

import javax.swing.Icon;

import com.dci.intellij.dbn.common.Icons;

public enum SessionBrowserFilterType {
    USER("user", Icons.SB_FILTER_USER),
    HOST("host", Icons.SB_FILTER_SERVER),
    STATUS("status", Icons.SB_FILTER_STATUS);

    private String name;
    private Icon icon;

    SessionBrowserFilterType(String name, Icon icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }
}
