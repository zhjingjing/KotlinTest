package com.zh.kotlin.singleton.java;

/**
 * create by zj on 2020/7/1
 */
public class SingleTon1 {
    private static SingleTon1 singleTon1 = new SingleTon1();

    private SingleTon1() {
    }

    public static SingleTon1 getInstance() {
        return singleTon1;
    }
}
