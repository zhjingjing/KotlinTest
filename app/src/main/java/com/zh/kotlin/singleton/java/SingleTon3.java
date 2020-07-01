package com.zh.kotlin.singleton.java;

/**
 * create by zj on 2020/7/1
 * 同步锁 线程安全的懒加载
 */
public class SingleTon3 {
    private static SingleTon3 instance;

    private SingleTon3() {
    }

    public static synchronized SingleTon3 getInstance() {
        if (instance == null) {
            instance = new SingleTon3();
        }
        return instance;
    }
}
