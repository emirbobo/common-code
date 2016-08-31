package com.dci.intellij.dbn.codegenerator.conf;

import com.dci.intellij.dbn.codegenerator.exception.GeneratorException;
import com.dci.intellij.dbn.codegenerator.util.GeneratorUtil;
import com.dci.intellij.dbn.codegenerator.util.MybatisConstants;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.util.Properties;

/**
 * Created by xijingbo on 2016-02-03.
 */
public class MyBatisGeneratorConfig extends GeneratorConfig{
    public String getDbName() {
        return dbName;
    }

    public MyBatisGeneratorConfig() {
    }


    public void init( String workSpace,
                      String modelModule,
                      String serviceModule,
                      String mapperModule,
                      String connectionURL,
                      String driverLib,String userId,
                      String password,
                      String driverClass, String dbName,
                      String tableNames, String modelPackage,
                      String servicePackage,String mapperPackage,
                      boolean createService,
                      boolean mavenModule) {
        this.workSpace = workSpace;
        this.modelModule = modelModule;
        this.serviceModule = serviceModule;
        this.mapperModule = mapperModule;
        this.connectionURL = connectionURL;
        this.dbName = dbName;
        this.driverClass = driverClass;
        this.modelPackage = modelPackage;
        this.password = password;
        this.servicePackage = servicePackage;
        this.tableNames = tableNames;
        this.userId = userId;
        this.createService = createService;
        this.mapperPackage = mapperPackage;
        this.mavenModule = mavenModule;
        this.driverLib = driverLib;
    }

    public String initVE()  {
        mavenModule = false;
        String resourcePath = GeneratorUtil.getVMDir();
        File dir = new File(resourcePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        VelocityContext context = new VelocityContext();
        String jarFile = MyBatisGeneratorConfig.class.getResource("").getFile();
        jarFile = jarFile.substring(jarFile.indexOf("/")+1,jarFile.lastIndexOf("!"));
        Properties p =new Properties();
        p.setProperty("resource.loader", "jar");
        p.setProperty("jar.resource.loader.class", "org.apache.velocity.runtime.resource.loader.JarResourceLoader");
        p.setProperty("jar.resource.loader.path", "jar:file:" + jarFile);
//        Messages.showMessageDialog(ProjectManager.getInstance().getDefaultProject(), String.format("jarFile path" + jarFile), "Information", Messages.getInformationIcon());
        System.out.println(jarFile);
        Velocity.init(p);

        Template t = Velocity.getTemplate("resources/"+MybatisConstants.MYBATIS_CONFIG_VM,"UTF-8");
        context.put("driverLib",driverLib);
        context.put("userId", userId);
        context.put("password", password);
        context.put("connectionURL", connectionURL);
        context.put("driverClass", driverClass);
        context.put("daoPackage", mapperPackage);
        context.put("modelPackage",modelPackage);
        context.put("tableNames", GeneratorUtil.parseTableNames(tableNames));
        context.put("workSpace",workSpace);
        context.put("modelModule", GeneratorUtil.getModelPath(workSpace, modelModule, mavenModule) );

        context.put("serviceModule", GeneratorUtil.getModelPath(workSpace, serviceModule, mavenModule) );
        context.put("mapperModule",  GeneratorUtil.getModelPath(workSpace,mapperModule,mavenModule) );

        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        String configFile = resourcePath +  MybatisConstants.MYBATIS_CONFIG;
        FileOutputStream of = null;
        try {
            of = new FileOutputStream(configFile);
            of.write(writer.toString().getBytes("utf-8"));
            of.flush();
            of.close();
        } catch (IOException e){
             e.printStackTrace();
        }
        return configFile;
    }
    @Override
    protected Object setupConfig()  {
        return initVE();
//        VelocityContext context = new VelocityContext();
//        String resourcePath = GeneratorUtil.getVMDir();
//        File f = new File(resourcePath);
//        if(!f.exists()){
//            f.mkdirs();
//        }
//
//        String templateName = MybatisConstants.MYBATIS_CONFIG_VM;
//
//        String outputConfigName = MybatisConstants.MYBATIS_CONFIG;
//
//        VelocityEngine ve = new VelocityEngine();
//        Properties p =new Properties();
//        p.put(ve.FILE_RESOURCE_LOADER_PATH, "src/resources/");
//        ve.init(p);
//
//        Template t = ve.getTemplate(templateName,"utf-8");
//
//        context.put("userId", userId);
//        context.put("password", password);
//        context.put("connectionURL", connectionURL);
//        context.put("driverClass", driverClass);
//        context.put("daoPackage", mapperPackage);
//        context.put("modelPackage",modelPackage);
//        context.put("tableNames", GeneratorUtil.parseTableNames(tableNames));
//        context.put("workSpace",workSpace);
//        context.put("modelModule", GeneratorUtil.getModelPath(workSpace, modelModule, mavenModule) );
//
//        context.put("serviceModule", GeneratorUtil.getModelPath(workSpace, serviceModule, mavenModule) );
//        context.put("mapperModule",  GeneratorUtil.getModelPath(workSpace,mapperModule,mavenModule) );
//
//        StringWriter writer = new StringWriter();
//        t.merge(context, writer);
//        String configFile = resourcePath + outputConfigName;
//        try {
//            FileOutputStream of = new FileOutputStream(configFile);
//
//            of.write(writer.toString().getBytes("utf-8"));
//            of.flush();
//            of.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return configFile;
    }




}
