package com.zh.baselib.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * create by zj on 2020/7/3
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 初始化数据
     * */
    private fun initData() {
    }

    /**
     * 初始化adapter，listener
     * */
    private fun initListener() {
    }

    abstract fun getLayoutId(): Int

    fun myToast(msg: String) {
        runOnUiThread { Toast.makeText(this, msg, Toast.LENGTH_SHORT).show() }
    }

}