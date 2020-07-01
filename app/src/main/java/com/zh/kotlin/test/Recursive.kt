package com.zh.kotlin.test

import java.math.BigDecimal
import java.math.BigInteger

/**
 * create by zj on 2020/7/1
 */

fun main() {
    var result = doRecursive(BigDecimal("10000"), BigDecimal("1"))
    print(result)
}

/*
* 递归优化
* 使用tailrec关键字修饰
* 返回值返回方法，不要使用num*方法（num-1）否则计算量大了之后会出现StackOverflowError
* */
tailrec fun doRecursive(num: BigDecimal, result: BigDecimal, doNum: Int = 1): BigDecimal {
    return if (num == BigDecimal.ONE) {
        result * BigDecimal.ONE
    } else {
        doRecursive(num - BigDecimal.ONE, result * num)
    }
}