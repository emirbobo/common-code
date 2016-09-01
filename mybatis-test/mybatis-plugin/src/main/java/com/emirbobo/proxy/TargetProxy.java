package com.emirbobo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xijingbo on 2016-08-31.
 */
public class TargetProxy implements InvocationHandler {
    private Object target;

    private Interceptor interceptor;

    private TargetProxy(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    // 将拦截逻辑封装到拦截器中，有客户端生成目标类的代理类的时候一起传入，这样客户端就可以设置不同的拦截逻辑。
    public static Object bind(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TargetProxy(target, interceptor));
    }

//    // 在执行目标对象方法前加上自己的拦截逻辑
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        // 执行客户端定义的拦截逻辑
//        return interceptor.intercept(new Invocation(target,method, args));
//    }

    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
        MethodName methodName =
                this.interceptor.getClass().getAnnotation(MethodName.class);
        //如果注解上的方法名和该方法名一样，才拦截
        String name = methodName.value();
        if (name.equals(method.getName())) {
            System.out.println("invoke " + method.getName());
            return interceptor.intercept(new Invocation(target, method, args));
        }

        return method.invoke(this.target, args);
    }
}
