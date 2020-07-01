package com.zh.kotlin.singleton.kotlin

/**
 * create by zj on 2020/7/1
 */
class SingleTon5 {
    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = SingleTon5()
    }
}