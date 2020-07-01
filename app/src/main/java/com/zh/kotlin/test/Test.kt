package com.zh.kotlin.test

import com.zh.kotlin.utils.findMax

/**
 * create by zj on 2020/6/22
 */
fun main() {
    val list = listOf("watermelon", "apple", "banana", "zoo")
    val result = list.maxBy { it.length }

    val result2 = list.findMax { it.length }
    println(result)
    println(result2)
}

