package com.dci.intellij.dbn.codegenerator.listener;

import com.dci.intellij.dbn.codegenerator.conf.GeneratorConfig;
import com.dci.intellij.dbn.codegenerator.conf.MyBatisGeneratorConfig;
import com.dci.intellij.dbn.codegenerator.conf.ServiceGeneratorConfig;
import com.dci.intellij.dbn.codegenerator.exception.GeneratorException;
import com.dci.intellij.dbn.codegenerator.generator.BaseGenerator;
import com.dci.intellij.dbn.codegenerator.generator.MybatisGenerator;
import com.dci.intellij.dbn.codegenerator.generator.ServiceGenerator;
import com.dci.intellij.dbn.codegenerator.method.ClassType;
import com.dci.intellij.dbn.codegenerator.util.GeneratorUtil;
import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.connection.ConnectionBundle;
import com.dci.intellij.dbn.connection.ConnectionHandler;
import com.dci.intellij.dbn.connection.ConnectionManager;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.kohsuke.rngom.parse.host.Base;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xijingbo on 2016-02-01.
 */
public class CodeGeneratorListener  extends MouseAdapter {

    List<BaseGenerator> generatorConfigs = Lists.newArrayList();
//    MyBatisGeneratorConfig myBatisGeneratorConfig;
    Project project;
    String workSpace;
    String modelModule;
    String serviceModule;
    String mapperModule;
    String dbName;
    String tableNames;
    String modelPackage;
    String servicePackage;
    String mapperPackage;
    boolean generateServiceCheckBox;
    boolean mavenModule;
    public CodeGeneratorListener() {
    }

    public CodeGeneratorListener(Project project) {
        this.project = project;
    }

    public void apply(  String workSpace,String modelModule, String serviceModule,
                                         String mapperModule,  String dbName, String tableNames,
                                         String modelPackage,  String servicePackage,
                                         String mapperPackage,boolean generateServiceCheckBox,boolean mavenModule){
//        Messages.showMessageDialog(project,
//                String.format(workSpace+"-"+modelModule), "Information", Messages.getInformationIcon());

        this.dbName = dbName;
        this.generateServiceCheckBox = generateServiceCheckBox;
        this.mapperModule = mapperModule;
        this.mapperPackage = mapperPackage;
        this.mavenModule = mavenModule;
        this.modelModule = modelModule;
        this.modelPackage = modelPackage;
        this.serviceModule = serviceModule;
        this.servicePackage = servicePackage;
        this.tableNames = tableNames;
        this.workSpace = workSpace;
//        return this;
    }

    public void pushConfig(BaseGenerator generator){
        generatorConfigs.add(generator);
    }

    public void clearConfig(){
        generatorConfigs.clear();
    }

    /**
     * do check package format by zz
     * @param packageName
     * @return
     */
    private boolean checkPackege(String packageName){
        if(packageName.length() >= Integer.MAX_VALUE){
            return false;
        }
        Pattern pattern = Pattern.compile("^([a-zA-Z]+[0-9]*\\.?)*[a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(packageName);
        if(!matcher.matches()){
            return false;
        }
        return true;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int result = Messages.showYesNoDialog(project,"do you confirm generator ?","info","Yes","No", Icons.DIALOG_WARNING);
        if(result == Messages.NO){
            return;
        }
        if(!checkPackege(modelPackage)){
            Messages.showMessageDialog(project,
                    String.format("modelPackage not Match Pachage Format!"), "Generator Error", Messages.getWarningIcon());
            return;
        }
        if(!checkPackege(servicePackage)){
            Messages.showMessageDialog(project,
                    String.format("servicePackage not Match Pachage Format!"), "Generator Error", Messages.getWarningIcon());
            return;
        }
        if(!checkPackege(mapperPackage)){
            Messages.showMessageDialog(project,
                    String.format("mapperPackage not Match Pachage Format!"), "Generator Error", Messages.getWarningIcon());
            return;
        }
//        MybatisGenerator mybatisGenerator = new MybatisGenerator(myBatisGeneratorConfig);
//        mybatisGenerator.generatorCode();
        clearConfig();
        init();
        for(BaseGenerator generatorConfig : generatorConfigs){
            generatorConfig.generatorCode();
        }
        Messages.showMessageDialog(project,
                String.format("Generator Done!"), "Information", Messages.getInformationIcon());
    }

    public boolean init(){
        if (project != null) {

            ConnectionManager connectionManager = ConnectionManager.getInstance(project);
            if (null == connectionManager) {
                Messages.showMessageDialog(project,
                        String.format("connectionManager is null"), "Information", Messages.getInformationIcon());
                return false;
            }

            final ConnectionBundle connectionBundle = connectionManager.getConnectionBundle();
            if (connectionBundle.getConnectionHandlers().size() > 0) {
                for (ConnectionHandler connectionHandler : connectionBundle.getConnectionHandlers()) {
                    if (dbName.equals(connectionHandler.getName())) {
                        String url = connectionHandler.getSettings().getDatabaseSettings().getDatabaseUrl();
                        dbName = url.substring(url.lastIndexOf("/")+1);
                        Messages.showMessageDialog(project,
                                String.format("select database :"+dbName), "Information", Messages.getInformationIcon());
                        //generator mybatis
                        MyBatisGeneratorConfig myBatisGeneratorConfig = new MyBatisGeneratorConfig() ;
                        myBatisGeneratorConfig.init(workSpace,modelModule, serviceModule, mapperModule,
                                connectionHandler.getSettings().getDatabaseSettings().getDatabaseUrl(),
                                connectionHandler.getSettings().getDatabaseSettings().getDriverLibrary(),
                                connectionHandler.getSettings().getDatabaseSettings().getUser(),
                                connectionHandler.getSettings().getDatabaseSettings().getPassword(),
                                connectionHandler.getSettings().getDatabaseSettings().getDriver(),
                                dbName,
                                tableNames,
                                modelPackage,
                                servicePackage,
                                mapperPackage,
                                generateServiceCheckBox,
                                mavenModule);
                        pushConfig(new MybatisGenerator(myBatisGeneratorConfig));
                        if(generateServiceCheckBox) {
                            //generator service
                            for (String tableName : tableNames.split(",")) {

                                //generator impl
                                ServiceGeneratorConfig serviceGeneratorConfig = new ServiceGeneratorConfig(ClassType.implClass,null,tableName);
                                serviceGeneratorConfig.init(workSpace, modelModule, serviceModule, mapperModule,
                                        dbName,
                                        tableNames,
                                        modelPackage,
                                        servicePackage,// GeneratorUtil.getServiceImplPackage(servicePackage,workSpace,modelModule,mavenModule),
                                        mapperPackage,
                                        generateServiceCheckBox,
                                        mavenModule);
                                serviceGeneratorConfig.setTableName(tableName);
                                pushConfig(new ServiceGenerator(serviceGeneratorConfig));

                                //generator interface
                                ServiceGeneratorConfig serviceInterfaceGeneratorConfig = new ServiceGeneratorConfig(ClassType.interfaceClass,new Integer[]{1},tableName);
                                serviceInterfaceGeneratorConfig.init(workSpace, modelModule, serviceModule, mapperModule,
                                        dbName,
                                        tableNames,
                                        modelPackage,
                                        servicePackage,
                                        mapperPackage,
                                        generateServiceCheckBox,
                                        mavenModule);
                                serviceInterfaceGeneratorConfig.setTableName(tableName);
                                pushConfig(new ServiceGenerator(serviceInterfaceGeneratorConfig));
                            }
                        }
                    }
                }
            }else{
                Messages.showMessageDialog(project,
                        String.format("need connection settings"), "Information", Messages.getInformationIcon());
                return false;
            }
        }
        return true;
    }

    private boolean createDir(String packagePath){
        try {
            if (StringUtils.isBlank(packagePath)) {
                return false;
            }
            if (packagePath.contains("\\.")) {
                packagePath = packagePath.replaceAll("\\.", "/");
            }
            File pkg = new File(packagePath);
            if (!pkg.exists()) {
                pkg.mkdirs();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
