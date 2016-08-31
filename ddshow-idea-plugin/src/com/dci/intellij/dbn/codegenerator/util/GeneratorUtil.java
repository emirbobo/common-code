package com.dci.intellij.dbn.codegenerator.util;

import com.dci.intellij.dbn.codegenerator.method.ClassType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by xijingbo on 2016-02-18.
 */
public class GeneratorUtil {

    /**
     *
     * @param tableNames
     * @return Map<tableName,modelName>
     */
    public static Map<String,String> parseTableNames(String tableNames){

        Map<String,String> result = Maps.newHashMap();
        String [] tns = tableNames.split(",");
        for(int i=0;i<tns.length;i++){
            String t = tns[i];
            if(t!=null){
                String tn = parseModelName(t);
                result.put(t,tn);
            }
            System.out.println(t+"-"+result.get(t));
        }
        return result;
    }
    @Test
    public void test(){
//        System.out.println(getModelPath("c:\\ddshow","ddshow-model",true));
//        parseTableNames("t_user,t_room");
//        System.out.println("com.test.impl".replace(".",File.separator));
        System.out.print(new StringBuffer("\r\n\tb"));
    }



    public static String parseModelName(@NotNull String tableName){
        StringBuffer sb = new StringBuffer();
        if(tableName.indexOf("_") > 0){
            String[] tablesplit = tableName.split("_");
            if(tablesplit[0].equalsIgnoreCase("t")){
                for(int i = 0;i<tablesplit.length;i++){
                    if(i == 0){
                        continue;
                    }
                    String w = tablesplit[i];
                    char f = w.charAt(0);
                    w = w.replace(w.charAt(0),(f+"").toUpperCase().charAt(0));
                    sb.append(w);
                }
            }
        }
        return sb.toString();
    }

    /**
     *
     * @param workSpace
     * @param modelName
     * @param mavenModule
     * @return  d:\\ddshow\\ddshow-model\\src\\main\\java\\
     */
    public static String getModelPath(@NotNull String workSpace,@NotNull String modelName,boolean mavenModule){
        String modelPath = workSpace +  File.separator + modelName;
        return  mavenModule ? modelPath + File.separator + MybatisConstants.MAVEN_MODULE : modelPath ;
    }

    public static String getMapperName(String modelName){
        return modelName + "Mapper";
    }

    public static String getServiceName(String tableName,ClassType classType){
        if(classType == ClassType.implClass){
            return getServiceImplName(tableName);
        }
        return getServiceInterfaceName(tableName);
    }

    public static String getServiceFileName(String serviceName){
        return serviceName + ".java";
//        if(classType == ClassType.implClass){
//            return getServiceImplClassName(serviceName);
//        }
//        return getServiceInterfaceClassName(serviceName);
    }

    private static String getServiceInterfaceName(String tableName){
        return parseModelName(tableName)+ "Service";
    }

    private static String getServiceImplName(String tableName){
        return parseModelName(tableName)+ "ServiceImpl";
    }

//    private static String getServiceInterfaceClassName(String serviceName){
//        return getServiceInterfaceName(tableName) + ".java";
//    }
//
//    private static String getServiceImplClassName(String serviceName){
//        return getServiceImplName(tableName) + ".java";
//    }

    public static String getAndCreatePackage(ClassType classType,String servicePackage,String workSpace,String modelName,boolean mavenModule){
        if(classType == ClassType.implClass){
            servicePackage += ".impl";
        }
        return createServiceImplPackage(servicePackage,workSpace,modelName,mavenModule);
    }

    /**
     * return  dir realPath
     * @param servicePackage
     * @param workSpace
     * @param modelName
     * @param mavenModule
     * @return
     */
    public static String createServiceImplPackage(String servicePackage,String workSpace,String modelName,boolean mavenModule){
//        String implPackage =  servicePackage + ".impl";     //com.test.impl
        String implPackageDir = servicePackage.replace(".",File.separator); //com/test/impl
        String realPath = getModelPath(workSpace, modelName, mavenModule)+File.separator+implPackageDir;//d:\\ddshow\\ddshow-model\\src\\main\\java\\com\\test\\impl

//        Messages.showMessageDialog(ProjectManager.getInstance().getDefaultProject(),
//                String.format("create realPath: " + realPath), "Information", Messages.getInformationIcon());
        File pkgDir = new File(realPath);
        if(!pkgDir.exists()){
            pkgDir.mkdirs();
        }
        return realPath;
    }

    public static  List<String> parseImports(String servicePackage,String modelPackage,String mapperPackage,String tableName,ClassType classType){
        List<String> imports = Lists.newArrayList();
        imports.add("import "+ modelPackage+"."+GeneratorUtil.parseModelName(tableName)+";");
        if(classType == ClassType.implClass){
            imports.add("import "+ mapperPackage+"."+GeneratorUtil.getMapperName(GeneratorUtil.parseModelName(tableName)) + ";");
            imports.add("import " + servicePackage + "." + GeneratorUtil.getServiceInterfaceName(tableName) + ";");
        }
        return imports;
    }

    public static  String getServicePackage(String servicePackage,ClassType classType){
        if(classType == ClassType.implClass)
            return servicePackage + ".impl";
        return servicePackage;
    }

    public static String getSystemDrive(){
        return System.getenv("SystemDrive")+ File.separator;
    }

    public static String getVMDir(){
        return System.getenv("SystemDrive")+ File.separator+"ddshow"+File.separator;
    }

    public static String getParams(Pair[] classNames){
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

    public static String getParamNames(@NotNull Pair[] paramNames){
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

    public static String getAutowired(String mapperName,ClassType classType){
        if(classType == ClassType.implClass){
            return mapperName + " " + MybatisConstants.fristToLowerCase(mapperName) + ";"+separator;
        }
        return "";
    }

    public static String getExtendsStr(String tableName,ClassType classType){
        if(classType == ClassType.implClass){
            return "implements " + getServiceInterfaceName(tableName);
        }
        return "";
    }

    public final static String separator = "\r\n";
    public final static String tab = "\t";


}
