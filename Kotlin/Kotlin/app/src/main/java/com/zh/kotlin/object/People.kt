package com.zh.kotlin.`object`


/**
 * create by zj on 2020/5/14
 */
class People {

    private fun getName() = object {
        val name: String = "xxxx"
    }

    fun getName2() = object {
        val name: String = "yyy"
    }

    fun main() {
        val s1 = getName().name
//        val s2=getName2().name//无法调用到name。
    }

}