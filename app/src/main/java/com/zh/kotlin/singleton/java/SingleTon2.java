package com.zh.kotlin.singleton.java;

/**
 * create by zj on 2020/7/1
 * 懒加载
 */
public class SingleTon2 {
    private static SingleTon2 singleTon;

    private SingleTon2() {
    }

    public static SingleTon2 getInstance() {
        if (singleTon == null) {
            singleTon = new SingleTon2();
        }
        return singleTon;
    }
}
