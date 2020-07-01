package com.zh.kotlin.singleton.java;

/**
 * create by zj on 2020/7/1
 * 静态内部类
 */
public class SingleTon5 {
    private static class Holder {
        private static SingleTon5 instance = new SingleTon5();
    }

    private SingleTon5() {
    }

    public static SingleTon5 getInstance() {
        return Holder.instance;
    }
}
