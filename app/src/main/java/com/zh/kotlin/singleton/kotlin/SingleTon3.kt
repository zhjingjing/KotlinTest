package com.zh.kotlin.singleton.kotlin


/**
 * create by zj on 2020/7/1
 * 同步锁 线程安全的懒加载
 */
class SingleTon3 {
    companion object {
        private var instance: SingleTon3? = null

        @Synchronized
        fun getInstance(): SingleTon3 {
            if (instance == null) {
                instance = SingleTon3()
            }
            return instance!!
        }

    }
}