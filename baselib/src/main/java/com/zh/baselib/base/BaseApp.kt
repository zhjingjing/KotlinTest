package com.zh.baselib.base

import android.app.Application

/**
 * create by zj on 2020/7/7
 */
class BaseApp : Application() {
    companion object {
        lateinit var instance: BaseApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}