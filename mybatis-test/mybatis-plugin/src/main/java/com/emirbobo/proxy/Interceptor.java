package com.emirbobo.proxy;

/**
 * Created by xijingbo on 2016-08-30.
 */
public interface Interceptor {

//    void Intercept();

    Object intercept(Invocation invocation) throws Throwable;

    public Object register(Object target);
}
