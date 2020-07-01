package com.zh.kotlin.singleton.kotlin


/**
 * create by zj on 2020/7/1
 */
class SingleTon4 {
    companion object {

        val instance2 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingleTon4()
        }
    }


}