package com.dci.intellij.dbn.codegenerator.util;

import com.dci.intellij.dbn.codegenerator.method.ServiceMethod;
import com.intellij.openapi.util.Pair;
import org.junit.Test;

import java.io.File;

/**
 * Created by xijingbo on 2016-02-03.
 */
public class MybatisConstants {

    public static final String MYBATIS_CONFIG = "myBatisGeneratorConfig.xml";
    public static final String MYBATIS_CONFIG_VM = "myBatisGeneratorConfig.vm";
    public static final String SERVICE_GENERATOR_CONFIG_VM = "serviceConfig.vm";
    public static final String MAVEN_MODULE = "src"+ File.separator+"main"+File.separator+"java" ;
    public static final String MAVEN_PACKAGE = "src.main.java." ;

    public static String fristToUpperCase(String str){
        String w = str;
        char f = str.charAt(0);
        w = w.replace(w.charAt(0),(f+"").toUpperCase().charAt(0));
        return w;
    }


    public static String fristToLowerCase(String str){
        String w = str;
        char f = str.charAt(0);
        w = w.replace(w.charAt(0),(f+"").toLowerCase().charAt(0));
        return w;
    }

    @Test
    public void test(){
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair("int","pkRoom");
//        System.out.println(ServiceMethod.selectByPrimaryKey.getClassMethod("Room",pairs,"roomMapper"));
     }
}
