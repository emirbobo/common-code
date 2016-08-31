package com.dci.intellij.dbn.codegenerator.options;

import com.dci.intellij.dbn.codegenerator.options.ui.CodeGeneralPlanForm;
import org.jetbrains.annotations.NotNull;

import com.dci.intellij.dbn.common.options.CompositeProjectConfiguration;
import com.dci.intellij.dbn.common.options.Configuration;
import com.dci.intellij.dbn.options.ConfigId;
import com.dci.intellij.dbn.options.ProjectSettingsManager;
import com.dci.intellij.dbn.options.TopLevelConfig;
import com.intellij.openapi.project.Project;

public class CodeGeneralPlan extends CompositeProjectConfiguration<CodeGeneralPlanForm> implements TopLevelConfig {
    private CodeGeneralSettings generalSettings ;

    public CodeGeneralPlan(Project project) {
        super(project);
        generalSettings = new CodeGeneralSettings(project);
    }

    public static CodeGeneralPlan getInstance(Project project) {
        return ProjectSettingsManager.getSettings(project).getCodeGeneralPlan();
    }

    @NotNull
    @Override
    public String getId() {
        return "DBNavigator.Project.CodeGeneralSettings";
    }

    public String getDisplayName() {
        return "Code General";
    }

    public String getHelpTopic() {
        return "codeGeneral";
    }

    @Override
    public ConfigId getConfigId() {
        return ConfigId.GENERATE_CODE;
    }

    @Override
    protected Configuration<CodeGeneralPlanForm> getOriginalSettings() {
        return getInstance(getProject());
    }

    /*********************************************************
     *                        Custom                         *
     *********************************************************/

    public CodeGeneralSettings getGeneralSettings() {
        return generalSettings;
    }

    /*********************************************************
     *                     Configuration                     *
     *********************************************************/
    public CodeGeneralPlanForm createConfigurationEditor() {
        return new CodeGeneralPlanForm(this);
    }

    @Override
    public String getConfigElementName() {
        return "code-general-settings";
    }

    protected Configuration[] createConfigurations() {
        return new Configuration[] {
                generalSettings};
    }
}
