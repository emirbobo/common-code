package com.dci.intellij.dbn.codegenerator.method;

import com.dci.intellij.dbn.codegenerator.util.GeneratorUtil;
import com.intellij.openapi.util.Pair;
import org.jetbrains.annotations.NotNull;

/**
 * Created by xijingbo on 2016-02-22.
 */
public enum ClassType {

    implClass("class")
//            {
//        @Override
//        public String buileMethod(String methodType,String methodName,@NotNull String returnType, @NotNull Pair<String, String>[] paramNames, @NotNull String mapperName) {
//            return createSerivceMethod(methodType,methodName,returnType,paramNames)+" {\n     " + getMethodContent(methodName,returnType,mapperName,paramNames) + " \n}";
//        }
//    }
    ,
    interfaceClass("interface")
//            {
//        @Override
//        public String buileMethod(String methodType,String methodName, @NotNull String returnType, @NotNull Pair<String, String>[] paramNames, @NotNull String mapperName) {
//            return createSerivceMethod(methodType,methodName,returnType,paramNames)+";";
//        }
//    }
    ,
    abstractClass("abstract")
//            {
//        @Override
//        public String buileMethod(String methodType,String methodName, @NotNull String returnType, @NotNull Pair<String, String>[] paramNames, @NotNull String mapperName) {
//            return null;
//        }
//    }
    ;

    String name;
    ClassType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }



//    public String createSerivceMethod(String methodType,String methodName,String returnType,Pair[] classNames){
//        return methodType +  " " + returnType + " " + methodName + "("+ GeneratorUtil.getParams(classNames) +")";
//    }
//
//    public String getMethodContent(String methodName,String returnType,String mapperName,@NotNull Pair[] paramNames){
//        StringBuffer sb = new StringBuffer();
//        if(!returnType.equals("void")){
//            sb.append("return").append(" ");
//        }
//        sb.append(mapperName).append(".").append(methodName).append("(").append( GeneratorUtil.getParamNames(paramNames)).append(");");
//        return sb.toString();
//    }

//    public abstract  String buileMethod(String methodType,String methodName,@NotNull String returnType,@NotNull Pair<String,String>[] paramNames,@NotNull String mapperName);
}
