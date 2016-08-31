package com.dci.intellij.dbn.codegenerator.method;

import com.dci.intellij.dbn.codegenerator.util.GeneratorUtil;
import com.dci.intellij.dbn.codegenerator.util.MybatisConstants;
import com.intellij.openapi.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by xijingbo on 2016-02-17.
 */
public enum ServiceMethod {

    deleteByPrimaryKey(1,"public","deleteByPrimaryKey"),

    insert(2,"public","insert"),

    insertSelective(3,"public","insertSelective") ,

    selectByPrimaryKey(4,"public","selectByPrimaryKey") ,

    updateByPrimaryKeySelective(5,"public","updateByPrimaryKeySelective") ,

    updateByPrimaryKey(6,"public","updateByPrimaryKey") ;

    int id;
    String methodType;
    String methodName;
//    String returnType;
//    String[] classNames;
//    String mapperName;


    ServiceMethod(int id, String methodType,
                  String methodName){
        this.id = id;
        this.methodName = methodName;
        this.methodType = methodType;
    }

    public String buileMethod(ClassType classType,@NotNull String returnType,@NotNull Pair<String,String>[] paramNames,@NotNull String mapperName){
        if(classType == ClassType.implClass){
            return getClassMethod(returnType,paramNames,mapperName);
        }else if(classType == ClassType.interfaceClass){
            return getInterfaceMethod(returnType,paramNames);
        }if(classType == ClassType.abstractClass){
            return "";
        }
        return "";
    }

    /**
     * build some methods by ids
     * @param classType
     * @param methodIds
     * @param returnType
     * @param paramNames
     * @param mapperName
     * @return
     */
    public List<String> buildMethods(ClassType classType,Integer[] methodIds,@NotNull String returnType,@NotNull Pair<String,String>[] paramNames,@NotNull String mapperName){
        return null;
    }

    private String createSerivceMethod(String returnType,Pair[] classNames){
        return methodType +  " " + returnType + " " + methodName + "("+ getParams(classNames) +")";
    }

    private String getParams(Pair[] classNames){
        StringBuffer params = new StringBuffer();
        for(Pair className : classNames){
            if(params.length()>0) {
                params.append(",");
            }

//            String w = MybatisConstants.fristToUpperCase(className);
            /**Class class,Class1 class1*/
            params.append(className.getFirst()).append(" ").append(className.getSecond());
        }
        return  params.toString();
    }

    private String getParamNames(@NotNull Pair[] paramNames){
        StringBuffer params = new StringBuffer();
        for(Pair param : paramNames){
            if(params.length()>0) {
                params.append(",");
            }
//            String w = MybatisConstants.fristToUpperCase(className);
            /**class,class1,class2*/
            params.append(param.getSecond());
        }
        return  params.toString();
    }

    private String getMethodContent(String returnType,String mapperName,@NotNull Pair[] paramNames){
        StringBuffer sb = new StringBuffer();
        if(!returnType.equals("void")){
            sb.append(GeneratorUtil.tab).append("return").append(" ");
        }
        sb.append(MybatisConstants.fristToLowerCase(mapperName)).append(".").append(methodName).append("(").append(getParamNames(paramNames)).append(");").append(GeneratorUtil.separator).append(GeneratorUtil.tab);
        return sb.toString();
    }



    private String getClassMethod(@NotNull String returnType,@NotNull Pair<String,String>[] paramNames,@NotNull String mapperName){
        return createSerivceMethod(returnType,paramNames)+" {     "+GeneratorUtil.separator + GeneratorUtil.tab+ getMethodContent(returnType,mapperName,paramNames) + "}"+GeneratorUtil.separator;
    }

    private String getInterfaceMethod(@NotNull String returnType,@NotNull Pair[] classNames){
        return createSerivceMethod(returnType,classNames)+";";
    }

//    public static void print(@NotNull String returnType,@NotNull Pair<String,String>[] paramNames,@NotNull String mapperName){
//        for(SerivceMethod serivceMethod : values()){
//            System.out.println(serivceMethod.getClassMethod(returnType,paramNames,mapperName));
//        }
//    }
}
