package com.emirbobo.proxy;


/**
 * Created by xijingbo on 2016-08-31.
 */
@MethodName("execute1")
public class InterceptorImpl implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Go Go Go!!!");
        return invocation.proceed();
    }

    public Object register(Object target) {
        return TargetProxy.bind(target, this);
    }
}
