package com.emirbobo.proxy;

/**
 * Created by xijingbo on 2016-08-31.
 */
public class Client {
    public static void main(String[] args) {

        Target target = new TargetImpl();
        Interceptor interceptor = new InterceptorImpl();
        target = (Target)TargetProxy.bind(target, interceptor);
        target.execute1();
    }
}
