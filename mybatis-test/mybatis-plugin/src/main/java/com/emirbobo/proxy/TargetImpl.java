package com.emirbobo.proxy;

/**
 * Created by xijingbo on 2016-08-31.
 */
public class TargetImpl implements Target {

    @Override
    public void execute1() {
        System.out.println("Execute1");

    }

    @Override
    public void execute2() {
        System.out.println("Execute2");
    }
}
