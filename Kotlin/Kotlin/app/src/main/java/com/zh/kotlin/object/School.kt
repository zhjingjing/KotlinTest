package com.zh.kotlin.`object`

/**
 * create by zj on 2020/5/14
 */
class School {
    companion object {
        var name: String = "xxx"
    }

    fun getName(): String {
        return School.name
    }

}