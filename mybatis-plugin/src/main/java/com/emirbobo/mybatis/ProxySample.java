package com.emirbobo.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xijingbo on 2016-08-30.
 */
public class ProxySample implements InvocationHandler {

    Object target ;

    Interceptor interceptor;

    public ProxySample(Object target,Interceptor interceptor){
        this.target = target;
        this.interceptor = interceptor;
    }

    public static Object bind(Object target,Interceptor interceptor ){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new ProxySample(target,interceptor));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return interceptor.Intercept(new Invocation(proxy,method,args));
//        return method.invoke(target,args);
    }
}
