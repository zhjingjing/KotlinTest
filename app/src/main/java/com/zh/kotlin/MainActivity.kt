package com.zh.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


        val list1 = listOf(1, 1, 1, null)

        for (i in list1) {
            println(i)
        }
        println("--------------------------")

        var size = list1.size - 1
        while (size >= 0) {
            println(list1[size])
            size--
        }
        println("--------------------------")

        list1.forEach { println(it) }
        val list4 = listOfNotNull(4, 4, 4, null)

        val list2 = mutableListOf(2, 2, 2, null)

        Log.e(tag, list1.toString())
        Log.e(tag, list2.toString())

        Log.e(tag, list4.toString())

        val list5 = arrayListOf(5, 5, 5)

        val list3 = emptyList<Int>()

        val set1 = setOf(1, 2, 3, 3, 2, 21, null)
        val set2 = mutableSetOf(1, 2, 3, 4, null)

        val set3 = hashSetOf(1, 2, 3, null)

        var set4 = linkedSetOf(1, 2, 3, 3)

        for (i in set1) {
            println(i)
        }
        println("set2 --------------------------")
        set2.add(3)
        set2.forEach { print(it) }
        println()
        println("set3--------------------------")
        set3.forEach { print(it) }
        println()
        println("set4--------------------------")
        println(set4)

        val map1 = mapOf(1 to "map1-1", 2 to "map1-2", null to null)
        val map2 = linkedMapOf(1 to "map2-1", 2 to "map2-2", null to null)
        val map3 = hashMapOf(1 to "map3-1", 2 to "map3-2", null to null)
        val map4 = mutableMapOf(1 to "map4-1", 2 to "map4-2", null to null)
        println("map1--------------------------")
        map1.forEach { (key, value) -> println("$key \t $value") }
        println("map2--------------------------")
        map2[3] = "map2-3"
        map2.forEach { (key, value) -> println("$key \t $value") }
        println("map3--------------------------")
        map3[3] = "map3-3"
        map3.forEach { (key, value) -> println("$key \t $value") }
        println("map4--------------------------")
        map4[4] = "map4-3"
        map4.forEach { (key, value) -> println("$key \t $value") }

        println("array0--------------------------")
        var array0 = Array(3) { i -> i + 1 }
        array0.forEach { println(it) }
        println("array1--------------------------")
        val array = arrayOf(1, 2, 3)
        array[1] = 100
        array.forEach { println(it) }


        val list = array.toList()

        list.forEach { println(it) }


        val listStr = listOf("list", "set", "map")
        val arrayStr = listStr.toTypedArray()
        arrayStr.forEach { println(it) }
    }


    private fun init() {
        Log.i(tag, "Hello World")
//        val errorNum = 10
//        errorNum += 10
//        Log.i(tag, errorNum.toString())

        var num = 10
        num += 10


        Log.i(tag, num.toString())

        Log.i(tag, addSum(num, 20).toString())
        Log.i(tag, addSum2(num).toString())
        Log.i(tag, addSum3(j = "xxxx"))

    }


    private fun addSum3(i: Int = 0, j: String): String {
        return j
    }

    private fun addSum(i1: Int, i2: Int): Int {
        return i1 + i2
    }

    private fun addSum2(i1: Int, i2: Int = 2): Int = i1 + i2


}
