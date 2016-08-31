package com.dci.intellij.dbn.codegenerator.options;

import com.dci.intellij.dbn.codegenerator.options.ui.CodeGeneralSettingForm;
import com.dci.intellij.dbn.common.options.Configuration;
import com.dci.intellij.dbn.common.options.setting.SettingsUtil;
import com.intellij.openapi.project.Project;
import org.jdom.Element;

public class CodeGeneralSettings extends Configuration<CodeGeneralSettingForm> {
//    private boolean generateModelCheckBox = false;
    private boolean generateServiceCheckBox = true;
    private String dbName;
    private String tableNames;
    private String modelPackage;
    private String servicePackage;
    private String workSpace;
    private String modelModule;
    private String serviceModule;
    private String mapperModule;
    private String mapperPackage;
    private boolean mavenModule = true;

    public boolean isMavenModule() {
        return mavenModule;
    }

    public void setMavenModule(boolean mavenModule) {
        this.mavenModule = mavenModule;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    private Project project;
    public CodeGeneralSettings(){
    }

    public String getMapperModule() {
        return mapperModule;
    }

    public void setMapperModule(String mapperModule) {
        this.mapperModule = mapperModule;
    }

    public String getModelModule() {
        return modelModule;
    }

    public void setModelModule(String modelModule) {
        this.modelModule = modelModule;
    }

    public String getServiceModule() {
        return serviceModule;
    }

    public void setServiceModule(String serviceModule) {
        this.serviceModule = serviceModule;
    }

    public String getWorkSpace() {
        return workSpace;
    }

    public void setWorkSpace(String workSpace) {
        this.workSpace = workSpace;
    }

    public CodeGeneralSettings(Project project){
        this.project = project;
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDisplayName() {
        return "Code general settings";
    }

    public String getHelpTopic() {
        return "codeGeneral";
    }


    /*********************************************************
    *                       Settings                        *
    *********************************************************/

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public boolean isGenerateServiceCheckBox() {
        return generateServiceCheckBox;
    }

    public void setGenerateServiceCheckBox(boolean generateServiceCheckBox) {
        this.generateServiceCheckBox = generateServiceCheckBox;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getTableNames() {
        return tableNames;
    }

    public void setTableNames(String tableNames) {
        this.tableNames = tableNames;
    }

    /****************************************************
     *                   Configuration                  *
     ****************************************************/
    public CodeGeneralSettingForm createConfigurationEditor() {
        return new CodeGeneralSettingForm(this);
    }

    @Override
    public String getConfigElementName() {
        return "general";
    }
    public void readConfiguration(Element element) {
        generateServiceCheckBox = SettingsUtil.getBoolean(element, "GenerateService", generateServiceCheckBox);
        dbName = SettingsUtil.getString(element, "dbName", dbName);
        tableNames = SettingsUtil.getString(element, "tableNames", tableNames);
        modelPackage = SettingsUtil.getString(element, "modelPackage", modelPackage);
        servicePackage = SettingsUtil.getString(element, "servicePackage", servicePackage);
        workSpace = SettingsUtil.getString(element, "workSpace", workSpace);
        modelModule = SettingsUtil.getString(element, "modelModule", modelModule);
        serviceModule = SettingsUtil.getString(element, "serviceModule", serviceModule);
        mapperModule = SettingsUtil.getString(element, "mapperModule", mapperModule);
        mapperPackage = SettingsUtil.getString(element, "mapperPackage", mapperPackage);
        mavenModule = SettingsUtil.getBoolean(element, "mavenModule", mavenModule);
    }

    public void writeConfiguration(Element element) {
        SettingsUtil.setBoolean(element, "GenerateService", generateServiceCheckBox);
        SettingsUtil.setString(element, "dbName", dbName);
        SettingsUtil.setString(element, "tableNames", tableNames);
        SettingsUtil.setString(element, "modelPackage", modelPackage);
        SettingsUtil.setString(element, "servicePackage", servicePackage);
        SettingsUtil.setString(element, "workSpace", workSpace);
        SettingsUtil.setString(element, "modelModule", modelModule);
        SettingsUtil.setString(element, "serviceModule", serviceModule);
        SettingsUtil.setString(element, "mapperModule", mapperModule);
        SettingsUtil.setString(element, "mapperPackage", mapperPackage);
        SettingsUtil.setBoolean(element, "mavenModule", mavenModule);

    }
}
