package com.zh.kotlin.recycler.chat

/**
 * create by zj on 2020/5/14
 * 消息体
 */
class Message(val id: Int, val msg: String, val type: Int) {
    companion object {
        val TYPE_LEFT = 0
        val TYPE_RIGHT = 1
    }
}
