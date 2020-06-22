package com.zh.kotlin.test

import kotlin.math.max

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

fun <T, R : Comparable<R>> List<T>.findMax(block: (T) -> R): T? {
    if (isEmpty()) return null
    var maxElement = get(0)
    var maxValue = block(maxElement)
    for (element in this) {
        val value = block(element)
        if (value > maxValue) {
            maxElement = element
            maxValue = value
        }
    }

    return maxElement
}