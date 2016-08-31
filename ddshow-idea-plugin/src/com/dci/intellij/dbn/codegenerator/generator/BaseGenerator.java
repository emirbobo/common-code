package com.dci.intellij.dbn.codegenerator.generator;

import com.dci.intellij.dbn.codegenerator.conf.GeneratorConfig;
import com.dci.intellij.dbn.codegenerator.exception.GeneratorException;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;

/**
 * Created by xijingbo on 2016-02-03.
 */
public abstract class BaseGenerator<C extends GeneratorConfig> {

    C generatorConfig;

    public BaseGenerator(C generatorConfig){
        this.generatorConfig = generatorConfig;
    }

    public void generatorCode(){
        Object configFile = null;
        try {
            configFile = generatorConfig.doWriteConfig();
        } catch (GeneratorException e) {
            e.printStackTrace();
        }
        doGenerateCode(configFile);
    }
    protected abstract void doGenerateCode(Object configFile);

}
