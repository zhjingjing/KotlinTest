package com.zh.kotlin.`object`

/**
 * create by zj on 2020/5/13
 */
object Person {
    var name = ""
    var age = 18

    override fun toString(): String {
        return "$name----$age"
    }
}