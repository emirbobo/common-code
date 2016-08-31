package com.emirbobo.mybatis;


/**
 * Created by xijingbo on 2016-08-30.
 */
public class ProxySampleTest {

    public static void main(String [] args){
        SampleInterface sif = (SampleInterface) ProxySample.bind(new SampleImpl(),new Interceptor() {
            @Override
            public Object Intercept(Invocation invocation) throws Throwable  {
                return invocation.proceed();
            }
        });
        sif.print();
    }
}
