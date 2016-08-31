package com.dci.intellij.dbn.codegenerator.method;

import com.dci.intellij.dbn.codegenerator.util.GeneratorUtil;
import com.dci.intellij.dbn.codegenerator.util.MybatisConstants;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.Pair;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.*;

/**
 * Created by xijingbo on 2016-02-22.
 */
public class ClassFactory {

    public static void createServiceClass(ServiceClass serviceClass){
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(serviceClass.getPackageName()).append(";").append(GeneratorUtil.separator).append(GeneratorUtil.separator);
        for(String importClass : serviceClass.getImports()){
            sb.append(importClass).append(GeneratorUtil.separator);
        }
        sb.append(GeneratorUtil.separator).append("public ").append(serviceClass.getClassType().getName()).append(" ").append(serviceClass.getClassName()).append(" ").append(serviceClass.getExtendsStr()).append(" {").append(GeneratorUtil.separator).append(GeneratorUtil.separator);//public class test{
        if(StringUtils.isNotEmpty(serviceClass.getAutowiredStr())) {
            sb.append(GeneratorUtil.tab).append("@Autowired").append(GeneratorUtil.separator);
            sb.append(GeneratorUtil.tab).append(serviceClass.getAutowiredStr()).append(GeneratorUtil.separator);
        }

        for(String serviceMethod : serviceClass.getMethods()){
            sb.append(GeneratorUtil.tab).append(serviceMethod).append(GeneratorUtil.separator);
        }
        sb.append(GeneratorUtil.separator).append("}").append(GeneratorUtil.separator);//}
        try {
//            Messages.showMessageDialog(ProjectManager.getInstance().getDefaultProject(),
//                    String.format("write generator service :" + sb.toString()), "Information", Messages.getInformationIcon());
            writeFile(new File(serviceClass.getPackageRealPath()+File.separator+ GeneratorUtil.getServiceFileName(serviceClass.getClassName())),sb.toString(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeFile(File file, String content, String fileEncoding) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, false);
        OutputStreamWriter osw;
        if (fileEncoding == null) {
            osw = new OutputStreamWriter(fos);
        } else {
            osw = new OutputStreamWriter(fos, fileEncoding);
        }

        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(content);
        bw.close();
    }
}
