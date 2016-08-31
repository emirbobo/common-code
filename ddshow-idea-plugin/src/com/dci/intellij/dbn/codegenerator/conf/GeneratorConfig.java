package com.dci.intellij.dbn.codegenerator.conf;

import com.dci.intellij.dbn.codegenerator.exception.GeneratorException;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by xijingbo on 2016-02-03.
 */
public abstract class GeneratorConfig  {

   protected String dbName;
   protected String tableNames;
   protected String modelPackage;
   protected String servicePackage;
   protected String mapperPackage;
   protected String driverClass;
   protected String connectionURL;
   protected String userId;
   protected String password;
   protected boolean createService;
   protected String workSpace;
   protected String modelModule;
   protected String serviceModule;
   protected String mapperModule;
   protected boolean mavenModule;
   protected String driverLib;

   public String getDriverLib() {
      return driverLib;
   }

   public void setDriverLib(String driverLib) {
      this.driverLib = driverLib;
   }

   public String getConnectionURL() {
      return connectionURL;
   }

   public void setConnectionURL(String connectionURL) {
      this.connectionURL = connectionURL;
   }

   public boolean isCreateService() {
      return createService;
   }

   public void setCreateService(boolean createService) {
      this.createService = createService;
   }

   public String getDbName() {
      return dbName;
   }

   public void setDbName(String dbName) {
      this.dbName = dbName;
   }

   public String getDriverClass() {
      return driverClass;
   }

   public void setDriverClass(String driverClass) {
      this.driverClass = driverClass;
   }

   public String getMapperModule() {
      return mapperModule;
   }

   public void setMapperModule(String mapperModule) {
      this.mapperModule = mapperModule;
   }

   public String getMapperPackage() {
      return mapperPackage;
   }

   public void setMapperPackage(String mapperPackage) {
      this.mapperPackage = mapperPackage;
   }

   public boolean isMavenModule() {
      return mavenModule;
   }

   public void setMavenModule(boolean mavenModule) {
      this.mavenModule = mavenModule;
   }

   public String getModelModule() {
      return modelModule;
   }

   public void setModelModule(String modelModule) {
      this.modelModule = modelModule;
   }

   public String getModelPackage() {
      return modelPackage;
   }

   public void setModelPackage(String modelPackage) {
      this.modelPackage = modelPackage;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getServiceModule() {
      return serviceModule;
   }

   public void setServiceModule(String serviceModule) {
      this.serviceModule = serviceModule;
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

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getWorkSpace() {
      return workSpace;
   }

   public void setWorkSpace(String workSpace) {
      this.workSpace = workSpace;
   }

   public GeneratorConfig() {

   }

   public GeneratorConfig(String connectionURL, boolean createService, String dbName, String driverClass, String mapperModule, String mapperPackage, boolean mavenModule, String modelModule, String modelPackage, String password, String serviceModule, String servicePackage, String tableNames, String userId, String workSpace) {
      this.connectionURL = connectionURL;
      this.createService = createService;
      this.dbName = dbName;
      this.driverClass = driverClass;
      this.mapperModule = mapperModule;
      this.mapperPackage = mapperPackage;
      this.mavenModule = mavenModule;
      this.modelModule = modelModule;
      this.modelPackage = modelPackage;
      this.password = password;
      this.serviceModule = serviceModule;
      this.servicePackage = servicePackage;
      this.tableNames = tableNames;
      this.userId = userId;
      this.workSpace = workSpace;
   }



   public Object doWriteConfig() throws GeneratorException {
         return setupConfig();
   }

   protected abstract Object setupConfig() throws GeneratorException;
}
