package com.emirbobo.mybatis;

/**
 * Created by xijingbo on 2016-08-30.
 */
public interface Interceptor {

//    void Intercept();

    Object Intercept(Invocation invocation) throws Throwable;
}
