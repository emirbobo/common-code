package com.emirbobo.mybatis;

/**
 * Created by xijingbo on 2016-08-30.
 */
public class SampleImpl implements SampleInterface {
    @Override
    public void print() {
        System.out.println("ProxySampleImpl invoke.");
    }
}
