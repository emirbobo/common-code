package com.dci.intellij.dbn.code.common.completion.options.filter.ui;

import com.dci.intellij.dbn.code.common.completion.options.filter.CodeCompletionFilterOption;
import com.dci.intellij.dbn.code.common.completion.options.filter.CodeCompletionFilterOptionBundle;
import com.intellij.ui.CheckedTreeNode;

public class CodeCompletionFilterTreeNode extends CheckedTreeNode {
    public CodeCompletionFilterTreeNode(Object userObject, boolean checked) {
        super(userObject);
        super.setChecked(checked);
    }

/*    public boolean isModified() {
        if (isModified) {
            return true;
        } else {
            for (int i = 0; i < getChildCount(); i++) {
                CodeCompletionSchemeTreeNode childNode = (CodeCompletionSchemeTreeNode) getChildAt(i);
                if (childNode.isModified()) {
                    return true;
                }
            }
        }
        return false;
    }*/

    public void applyChanges() {
        Object userObject = getUserObject();
        
        if (userObject instanceof CodeCompletionFilterOption) {
            CodeCompletionFilterOption option = (CodeCompletionFilterOption) userObject;
            option.setSelected(isChecked());
        } else {
            for (int i = 0; i < getChildCount(); i++) {
                CodeCompletionFilterTreeNode childNode = (CodeCompletionFilterTreeNode) getChildAt(i);
                childNode.applyChanges();
            }
        }
    }

    public void resetChanges() {
        Object userObject = getUserObject();

        if (userObject instanceof CodeCompletionFilterOption) {
            CodeCompletionFilterOption option = (CodeCompletionFilterOption) userObject;
            setCheckedSilently(option.isSelected());
        } else {
            for (int i = 0; i < getChildCount(); i++) {
                CodeCompletionFilterTreeNode childNode = (CodeCompletionFilterTreeNode) getChildAt(i);
                childNode.resetChanges();
            }
        }
    }

    public void setChecked(boolean checked) {
        setCheckedPropagateDown(checked);
        setCheckedPropagateUp(checked);
        Object userObject = getUserObject();

        if (userObject instanceof CodeCompletionFilterOption) {
            CodeCompletionFilterOption option = (CodeCompletionFilterOption) userObject;
            option.getFilterSettings().setModified(true);
        } else if (userObject instanceof CodeCompletionFilterOptionBundle) {
            CodeCompletionFilterOptionBundle optionBundle = (CodeCompletionFilterOptionBundle) userObject;
            optionBundle.getFilterSettings().setModified(true);
        }
    }

    public void setCheckedSilently(boolean checked) {
        super.setChecked(checked);
    }

    private void setCheckedPropagateDown(boolean checked) {
        setCheckedSilently(checked);
        for (int i = 0; i < getChildCount(); i++) {
            CodeCompletionFilterTreeNode childNode = (CodeCompletionFilterTreeNode) getChildAt(i);
            childNode.setCheckedPropagateDown(isChecked());
        }
    }

    private void setCheckedPropagateUp(boolean checked) {
        setCheckedSilently(checked);
        CodeCompletionFilterTreeNode parent = (CodeCompletionFilterTreeNode) getParent();
        while (parent != null) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                CheckedTreeNode treeNode = (CheckedTreeNode) parent.getChildAt(i);
                if (!treeNode.isChecked()) {
                    parent.setCheckedPropagateUp(false);
                    break;
                }
                if (i == parent.getChildCount() - 1) {
                    parent.setCheckedPropagateUp(true);
                }
            }
            parent = (CodeCompletionFilterTreeNode) parent.getParent();
        }
    }

    public void updateCheckedStatusFromChildren() {
        for (int i = 0; i < getChildCount(); i++) {
            CheckedTreeNode treeNode = (CheckedTreeNode) getChildAt(i);
            if (!treeNode.isChecked()) {
                setCheckedSilently(false);
                break;
            }
            if (i == getChildCount() - 1) {
                setCheckedPropagateUp(true);
            }
        }
    }

}
