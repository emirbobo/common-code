package com.dci.intellij.dbn.codegenerator.options.ui;

import com.dci.intellij.dbn.codegenerator.conf.MyBatisGeneratorConfig;
import com.dci.intellij.dbn.codegenerator.generator.MybatisGenerator;
import com.dci.intellij.dbn.codegenerator.listener.CodeGeneratorListener;
import com.dci.intellij.dbn.codegenerator.options.ChooseTablesDialog;
import com.dci.intellij.dbn.codegenerator.options.CodeGeneralSettings;
import com.dci.intellij.dbn.common.options.ui.ConfigurationEditorForm;
import com.dci.intellij.dbn.common.ui.list.CheckBoxList;
import com.dci.intellij.dbn.common.util.ActionUtil;
import com.dci.intellij.dbn.connection.ConnectionBundle;
import com.dci.intellij.dbn.connection.ConnectionHandler;
import com.dci.intellij.dbn.connection.ConnectionManager;
import com.dci.intellij.dbn.connection.console.DatabaseConsoleManager;
import com.dci.intellij.dbn.data.editor.text.TextContentType;
import com.dci.intellij.dbn.language.editor.action.CreateConsoleEditorAction;
import com.dci.intellij.dbn.vfs.DBConsoleVirtualFile;
import com.google.common.collect.Lists;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.DialogBuilder;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.PackageChooser;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.ui.popup.ComponentPopupBuilder;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.JBColor;
import com.intellij.ui.popup.ComponentPopupBuilderImpl;
import com.intellij.ui.popup.PopupComponent;
import com.intellij.util.ui.UIUtil;
import groovy.io.FileType;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeGeneralSettingForm extends ConfigurationEditorForm<CodeGeneralSettings> {
    private JButton generateCodeButton;
//    private JCheckBox generateModelCheckBox;
    private JCheckBox generateServiceCheckBox;
    private JPanel mainPanel;
    private JComboBox dbName;
    private JTextField tableNames;
    private JTextField servicePackage;
    private JTextField modelPackage;
    private TextFieldWithBrowseButton workSpace;
    private TextFieldWithBrowseButton modelModule;
    private TextFieldWithBrowseButton serviceModule;
    private TextFieldWithBrowseButton mapperModule;
    private JTextField mapperPackage;
    private JCheckBox mavenModule;
    CodeGeneratorListener codeGeneratorListener = new CodeGeneratorListener(getConfiguration().getProject());
    public CodeGeneralSettingForm(CodeGeneralSettings settings) {
        super(settings);
        updateBorderTitleForeground(mainPanel);
        resetFormChanges();
        registerComponent(mainPanel);
        init(INIT);
    }


    private static int INIT = 0;
    private static int APPLY = 1;
    private static int RESET = 2;

    public JPanel getComponent() {
        return mainPanel;
    }

    public void applyFormChanges() throws ConfigurationException {
        CodeGeneralSettings settings = getConfiguration();

//        settings.setGenerateModelCheckBox(generateModelCheckBox.isSelected());
        settings.setGenerateServiceCheckBox(generateServiceCheckBox.isSelected());
        settings.setDbName(dbName.getSelectedItem().toString());
        settings.setTableNames(tableNames.getText());
        settings.setModelPackage(modelPackage.getText());
        settings.setServicePackage(servicePackage.getText());
        settings.setMapperModule(mapperModule.getText());
        settings.setWorkSpace(workSpace.getText());
        settings.setModelModule(modelModule.getText());
        settings.setServiceModule(serviceModule.getText());
        settings.setMapperPackage(mapperPackage.getText());
        settings.setMavenModule(mavenModule.isSelected());
//        initTableNames(settings.getProject());
    }

    public void resetFormChanges() {
        CodeGeneralSettings settings = getConfiguration();
//        generateModelCheckBox.setSelected(settings.isGenerateModelCheckBox());
        generateServiceCheckBox.setSelected(settings.isGenerateServiceCheckBox());
        dbName.setSelectedItem(settings.getDbName());
        tableNames.setText(settings.getTableNames());
        modelPackage.setText(settings.getModelPackage());
        servicePackage.setText(settings.getServicePackage());
        mapperPackage.setText(settings.getMapperPackage());
        workSpace.setText(settings.getWorkSpace());
        modelModule.setText(settings.getModelModule());
        serviceModule.setText(settings.getServiceModule());
        mapperModule.setText(settings.getMapperModule());
        mavenModule.setSelected(settings.isMavenModule());
//        initTableNames(settings.getProject());
    }



    private static final FileChooserDescriptor LIBRARY_FILE_DESCRIPTOR = new FileChooserDescriptor(false, true, false, false, false, false);

    private void init(int type) {

        final CodeGeneralSettings settings = getConfiguration();
//        final MyBatisGeneratorConfig myBatisGeneratorConfig = new MyBatisGeneratorConfig() ;

        final Project project = settings.getProject();
        if (project != null) {

            workSpace.addBrowseFolderListener(
                    "Select ddshow WorkSpace",
                    "",
                    project, LIBRARY_FILE_DESCRIPTOR);
            modelModule.addBrowseFolderListener(
                    "Select modelModule",
                    "",
                    project, LIBRARY_FILE_DESCRIPTOR);
            serviceModule.addBrowseFolderListener(
                    "Select serviceModule",
                    "",
                    project, LIBRARY_FILE_DESCRIPTOR);
            mapperModule.addBrowseFolderListener(
                    "Select mapperModule",
                    "",
                    project, LIBRARY_FILE_DESCRIPTOR);

            ConnectionManager connectionManager = ConnectionManager.getInstance(project);
            if(null == connectionManager){
                Messages.showMessageDialog(project,
                        String.format("connectionManager is null"), "Information",Messages.getInformationIcon());
                return;
            }

            final ConnectionBundle connectionBundle = connectionManager.getConnectionBundle();
            if (connectionBundle.getConnectionHandlers().size() > 0) {
                for (ConnectionHandler connectionHandler : connectionBundle.getConnectionHandlers()) {
                    dbName.addItem(connectionHandler.getName());
                }
            }

            initTableNames(project);

            dbName.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    tableNames.setText("");
                }
            });

            generateCodeButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    codeGeneratorListener.apply(
                            workSpace.getText(),
                            getModuleName(modelModule.getText()),
                            getModuleName(serviceModule.getText()),
                            getModuleName(mapperModule.getText()),
                            dbName.getSelectedItem() != null ? dbName.getSelectedItem().toString() : "",
                            tableNames.getText(),
                            modelPackage.getText(),
                            servicePackage.getText(),
                            mapperPackage.getText(),
                            generateServiceCheckBox.isSelected(),
                            mavenModule.isSelected());
                }
            });

            generateCodeButton.addMouseListener(codeGeneratorListener);
        }else{
            Messages.showMessageDialog(project,
                    String.format("project plugin error ...."), "Information", Messages.getInformationIcon());

        }
    }

    MouseAdapter mouseAdapter;
    private void initTableNames(final Project project){
        if(mouseAdapter!=null){
            tableNames.removeMouseListener(mouseAdapter);
        }
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                    super.mouseClicked(e);
                ChooseTablesDialog chooseTableDialog = new ChooseTablesDialog(project, dbName.getSelectedItem().toString(), tableNames);
                chooseTableDialog.setModal(true);
                chooseTableDialog.show();
            }
        };
        tableNames.addMouseListener(mouseAdapter);
    }
    private String getModuleName(@NotNull String modulePath){
        return modulePath.substring(modulePath.lastIndexOf(File.separator)+1);
    }
}
