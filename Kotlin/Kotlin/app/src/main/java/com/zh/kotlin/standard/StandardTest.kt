package com.zh.kotlin.standard

import com.zh.kotlin.`object`.Person
import java.lang.StringBuilder
import kotlin.random.Random

/**
 * create by zj on 2020/5/13
 */
fun main() {
    val sss = with(StringBuilder()) {
        append("1")
        append("2")
        append("3")
        toString()
    }

    val ssss = StringBuilder().apply {
        append("1")
        append("2")
        append("3")
    }


    val ss = Person.apply {
        name = "zh"
        age = 19
    }.toString()


    val n = StringBuilder().also {
        it.append("1")
        it.append("2")
        it.append("3")
    }

    val s = StringBuilder().run {
        append("1")
        append("2")
        append("3")
        toString()
    }

    val a = StringBuilder().let {
        it.append("1")
        it.append("2")
        it.append("3")
    }

    val sb: StringBuilder? = null
    sb?.let {
        it.append("xxx")
    }

    val num = Random.nextInt(100)
    val takeIf = num.takeIf { it % 2 == 0 }
    val takeUnless = num.takeUnless { it % 2 == 0 }
    println("$num ----- $takeIf ---$takeUnless")

    val num1 = Random.nextInt(100)
    val takeIf1 = num1.takeIf { it % 2 == 0 }
    val takeUnless1 = num1.takeUnless { it % 2 == 0 }
    println("$num1 ----- $takeIf1 ---$takeUnless1")

    repeat(100) {
        println("这是repeat的$it")
    }
}


fun stringBuilder(): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append("1")
    stringBuilder.append("2")
    stringBuilder.append("3")
    return stringBuilder.toString()
}

