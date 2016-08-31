package com.dci.intellij.dbn.execution.statement.result.action;

import org.jetbrains.annotations.NotNull;

import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.common.util.ActionUtil;
import com.dci.intellij.dbn.options.ConfigId;
import com.dci.intellij.dbn.options.ProjectSettingsManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

public class ExecutionResultSettingsAction extends AbstractExecutionResultAction {
    public ExecutionResultSettingsAction() {
        super("Settings", Icons.EXEC_RESULT_OPTIONS);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = ActionUtil.getProject(e);
        if (project != null) {
            ProjectSettingsManager settingsManager = ProjectSettingsManager.getInstance(project);
            settingsManager.openProjectSettings(ConfigId.EXECUTION_ENGINE);
        }
    }

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        e.getPresentation().setText("Settings");
    }
}
