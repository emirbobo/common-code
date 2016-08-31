package com.dci.intellij.dbn.codegenerator.generator;

import com.dci.intellij.dbn.codegenerator.conf.MyBatisGeneratorConfig;
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
public class MybatisGenerator extends BaseGenerator {

    public MybatisGenerator(MyBatisGeneratorConfig generatorConfig) {
        super(generatorConfig);
    }

    @Override
    public void doGenerateCode(Object configFilePath) {

        Messages.showMessageDialog(ProjectManager.getInstance().getDefaultProject(),"start generate code " +configFilePath, "Information", Messages.getInformationIcon());
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File((String)configFilePath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
//            Messages.showMessageDialog(ProjectManager.getInstance().getDefaultProject(),String.format("start generate code configFile"+configFile), "Information", Messages.getInformationIcon());
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            Messages.showMessageDialog(ProjectManager.getInstance().getDefaultProject(), String.format("end generate code configFile" + configFile), "Information", Messages.getInformationIcon());
        } catch (Exception e) {
            e.printStackTrace();
            Messages.showMessageDialog(ProjectManager.getInstance().getDefaultProject(),
                    String.format("--:Exception" + e.getMessage() + e.toString()), "Information", Messages.getErrorIcon());
        }
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
