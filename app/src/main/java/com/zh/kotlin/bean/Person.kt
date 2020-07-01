package com.zh.kotlin.bean

/**
 * create by zj on 2020/6/24
 */

data class Person(var name: String) {
    var age: Int = 24
}


fun main() {
    var person=Person("ka")
    person.age=12
    println(person.toString())

    var person1=Person("ka")
    println(person===person1)
    println(person==person1)
    println(person.equals(person1))
}