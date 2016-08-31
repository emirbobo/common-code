package com.dci.intellij.dbn.codegenerator.exception;

/**
 * Created by xijingbo on 2016-02-17.
 */
public class GeneratorException extends Exception {
    public GeneratorException() {
        super();
    }

    public GeneratorException(String message) {
        super(message);
    }

    public GeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneratorException(Throwable cause) {
        super(cause);
    }
}
