package com.zh.kotlin.singleton.kotlin

/**
 * create by zj on 2020/7/1
 * 懒加载 线程不安全
 */
class SingleTon2 {
    companion object {
        //LazyThreadSafetyMode.NONE 没有锁
//        val instance by lazy(LazyThreadSafetyMode.NONE) {
//            SingleTon2()
//        }

        //下面是等价写法
        private var instance2: SingleTon2? = null
        fun getInstance(): SingleTon2 {
            if (instance2 == null) {
                instance2 = SingleTon2()
            }
            return instance2!!
        }


    }
}