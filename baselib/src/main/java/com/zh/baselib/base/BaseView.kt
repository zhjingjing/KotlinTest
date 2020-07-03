package com.zh.baselib.base

/**
 * create by zj on 2020/7/3
 */
interface BaseView {
    fun onError(msg: String)
    fun dismissLoading()
    fun showLoading()
}