package com.zh.kotlin.非诚勿扰

/**
 * create by zj on 2020/7/1
 */
data class UserBean(var name: String, var age: Int = 0, var height: Int = 170) {
}

var UserDao = listOf(
    UserBean(
        "笑笑",
        18, 168
    ), UserBean(
        "笑笑",
        19, 178
    ), UserBean("花花", 16, 170),
    UserBean("倪妮", 14, 160),
    UserBean("哒哒", 15, 150),
    UserBean("晓晓", 16, 180),
    UserBean("妮妮", 17, 160),
    UserBean("欢欢", 19),
    UserBean("嘤嘤", 21, 165),
    UserBean("嘤嘤", 18),
    UserBean("欢欢", 18)
)

fun main() {
    var list = arrayListOf<UserBean>()
    for (user in UserDao) {
        if (user.age >= 18) {
            list.add(user)
        }
    }


    println(list.maxBy {
        it.age
    })

    println(list.map {
        "${it.name}:${it.age}"
    })

    list.map {
        println(it)
    }

    var list2 = UserDao.filter {
        it.age >= 18
    }

    println(list == list2)

    println("查找数据库中年龄为18的人数：${UserDao.count { it.age == 18 }}")
    println("查找数据库中是否有年龄为18的人：${UserDao.any { it.age == 18 }}")
    println("查找数据库中第一个年龄为16的人：${UserDao.find { it.age == 16 }}")
    var list3 = UserDao.groupBy {
        it.name
    }
    println(list3)
}