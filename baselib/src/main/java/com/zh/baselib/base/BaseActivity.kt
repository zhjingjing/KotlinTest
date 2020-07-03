package com.zh.baselib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zh.baselib.utils.shortToast

/**
 * create by zj on 2020/7/3
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 初始化数据
     * */
    abstract fun initData()

    /**
     * 初始化adapter，listener
     * */
    abstract fun initListener()

    abstract fun getLayoutId(): Int

    fun myToast(msg: String) {
        runOnUiThread { shortToast(msg) }
    }

    override fun dismissLoading() {
    }

    override fun onError(msg: String) {
    }

    override fun showLoading() {
    }
}