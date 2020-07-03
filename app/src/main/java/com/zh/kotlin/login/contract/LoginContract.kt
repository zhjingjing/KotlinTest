package com.zh.kotlin.login.contract

import android.content.Context
import com.zh.baselib.base.BasePresenter
import com.zh.baselib.base.BaseView

/**
 * create by zj on 2020/7/3
 */
interface LoginContract {
    interface Presenter : BasePresenter<View> {
        fun doLogin(name: String, pwd: String)
        fun doRegister(context: Context)
    }

    interface View : BaseView {
        fun onNameError()
        fun pwdError()
        fun onLoginSuccess()
        fun onLoginError()
    }
}