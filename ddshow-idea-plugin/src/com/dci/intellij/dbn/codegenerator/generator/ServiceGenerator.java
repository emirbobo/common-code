package com.dci.intellij.dbn.codegenerator.generator;

import com.dci.intellij.dbn.codegenerator.conf.ServiceGeneratorConfig;
import com.dci.intellij.dbn.codegenerator.method.ClassFactory;
import com.dci.intellij.dbn.codegenerator.method.ServiceClass;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xijingbo on 2016-02-03.
 */
public class ServiceGenerator extends BaseGenerator {

    public ServiceGenerator(ServiceGeneratorConfig generatorConfig) {
        super(generatorConfig);
    }

    @Override
    public void doGenerateCode(Object o) {
        ServiceClass serviceClass = (ServiceClass)o;

        ClassFactory.createServiceClass(serviceClass);
    }

    public static void main(String [] args){

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        try {
            File configFile = new File("c:\\myBatisGeneratorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
