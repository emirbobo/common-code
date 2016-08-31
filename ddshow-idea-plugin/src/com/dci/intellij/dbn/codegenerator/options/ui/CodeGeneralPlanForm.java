package com.dci.intellij.dbn.codegenerator.options.ui;

import com.dci.intellij.dbn.codegenerator.options.CodeGeneralPlan;
import com.dci.intellij.dbn.codegenerator.options.CodeGeneralSettings;
import com.dci.intellij.dbn.common.options.ui.CompositeConfigurationEditorForm;
import com.dci.intellij.dbn.editor.code.options.CodeEditorSettings;

import javax.swing.*;
import java.awt.*;

public class CodeGeneralPlanForm extends CompositeConfigurationEditorForm<CodeGeneralPlan> {
    private JPanel mainPanel;
    private JPanel generalSettingsPanel;

    public CodeGeneralPlanForm(CodeGeneralPlan settings) {
        super(settings);
        generalSettingsPanel.add(settings.getGeneralSettings().createComponent(), BorderLayout.CENTER);
        resetFormChanges();
    }


    public JPanel getComponent() {
        return mainPanel;
    }
}
