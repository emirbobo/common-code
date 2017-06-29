package com.lang;

/**
 * Created by Mtime on 2017/3/8.
 */
public class UncheckException extends  RuntimeException {
    public UncheckException() {
        super();
    }

    public UncheckException(String message) {
        super(message);
    }

    public UncheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckException(Throwable cause) {
        super(cause);
    }

    protected UncheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
