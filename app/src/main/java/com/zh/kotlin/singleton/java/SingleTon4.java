package com.zh.kotlin.singleton.java;

/**
 * create by zj on 2020/7/1
 */
public class SingleTon4 {
    private static volatile SingleTon4 instance;

    private SingleTon4() {
    }

    public static SingleTon4 getInstance() {
        if (instance == null) {
            synchronized (SingleTon4.class) {
                if (instance == null) {
                    instance = new SingleTon4();
                }
            }
        }
        return instance;
    }

}
