package com.dci.intellij.dbn.codegenerator.method;

import java.util.List;

/**
 * Created by xijingbo on 2016-02-22.
 */
public class ServiceClass {

    String extendsStr;
    String packageName;
    List<String> imports;
    String className;
    String autowiredStr;
    List<String> methods;
    ClassType classType;
    String tableName;
    String packageRealPath;

    public String getPackageRealPath() {
        return packageRealPath;
    }

    public void setPackageRealPath(String packageRealPath) {
        this.packageRealPath = packageRealPath;
    }

    public ServiceClass() {
    }

    public String getAutowiredStr() {
        return autowiredStr;
    }

    public void setAutowiredStr(String autowiredStr) {
        this.autowiredStr = autowiredStr;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getExtendsStr() {
        return extendsStr;
    }

    public void setExtendsStr(String extendsStr) {
        this.extendsStr = extendsStr;
    }

    public ServiceClass(String extendsStr,String packageRealPath,String autowiredStr,String className,List<String> imports,String tableName, List<String> methods, String packageName,ClassType classType) {
        this.extendsStr = extendsStr;
        this.packageRealPath = packageRealPath;
        this.autowiredStr = autowiredStr;
        this.className = className;
        this.imports = imports;
        this.methods = methods;
        this.packageName = packageName;
        this.classType = classType;
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
