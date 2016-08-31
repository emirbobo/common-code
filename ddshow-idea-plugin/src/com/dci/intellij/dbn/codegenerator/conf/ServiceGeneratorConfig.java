package com.dci.intellij.dbn.codegenerator.conf;

import com.dci.intellij.dbn.codegenerator.exception.GeneratorException;
import com.dci.intellij.dbn.codegenerator.method.ClassType;
import com.dci.intellij.dbn.codegenerator.method.ServiceMethod;
import com.dci.intellij.dbn.codegenerator.method.ServiceClass;
import com.dci.intellij.dbn.codegenerator.util.GeneratorUtil;
import com.dci.intellij.dbn.codegenerator.util.MybatisConstants;
import com.google.common.collect.Lists;
import com.intellij.openapi.util.Pair;

import java.io.File;
import java.util.List;

/**
 * Created by xijingbo on 2016-02-17.
 */
public class ServiceGeneratorConfig extends GeneratorConfig {

    public ServiceGeneratorConfig(){

    }

    public ServiceGeneratorConfig(ClassType classType, Integer[] methodIds, String tableName) {
        this.classType = classType;
        this.methodIds = methodIds;
        this.tableName = tableName;
    }
    public void init( String workSpace,
                      String modelModule,
                      String serviceModule,
                      String mapperModule,
                      String dbName,
                      String tableNames, String modelPackage,
                      String servicePackage,String mapperPackage,
                      boolean createService,
                      boolean mavenModule) {
        this.workSpace = workSpace;
        this.modelModule = modelModule;
        this.serviceModule = serviceModule;
        this.mapperModule = mapperModule;
        this.dbName = dbName;
        this.modelPackage = modelPackage;
        this.servicePackage = servicePackage;
        this.tableNames = tableNames;
        this.createService = createService;
        this.mapperPackage = mapperPackage;
        this.mavenModule = mavenModule;
    }

    String tableName;
    ClassType classType;
    Integer methodIds[];//recordMethodId
    String packageRealPath;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    @Override
    public String getServicePackage() {
        return servicePackage;
    }

    @Override
    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    @Override
    protected Object setupConfig() throws GeneratorException {
        mavenModule = false;
        //generator dir package
        //config serviceClass
        List<String> methods = Lists.newArrayList();
        String modelName = GeneratorUtil.parseModelName(tableName);
        packageRealPath =  GeneratorUtil.getAndCreatePackage(classType, servicePackage, workSpace, serviceModule, mavenModule);
        String packageName = GeneratorUtil.getServicePackage(getServicePackage(),classType);
        String className = GeneratorUtil.getServiceName(tableName, classType);
        List<String> imports = GeneratorUtil.parseImports(servicePackage, modelPackage, mapperPackage, tableName, classType);
        String autowiredStr = GeneratorUtil.getAutowired(GeneratorUtil.getMapperName(modelName), classType);
        String extendsStr =GeneratorUtil.getExtendsStr(tableName,classType);
        setServicePackage(packageName);
        methods.add(ServiceMethod.insert.buileMethod(classType, "int", new Pair[]{new Pair(modelName, MybatisConstants.fristToLowerCase(modelName))}, GeneratorUtil.getMapperName(modelName)));
//            methods.add(SerivceMethod.insert.getInterfaceMethod("int", new Pair[]{new Pair(modelName, MybatisConstants.fristToUpperCase(modelName))}));
        return new ServiceClass(extendsStr,packageRealPath,autowiredStr,className,imports,tableName,methods,getServicePackage(),classType);
    }
}
