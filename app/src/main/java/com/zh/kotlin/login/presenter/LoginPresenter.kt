package com.zh.kotlin.login.presenter

import android.content.Context
import android.content.Intent
import com.zh.kotlin.login.contract.LoginContract
import com.zh.kotlin.register.RegisterActivity

/**
 * create by zj on 2020/7/3
 */
class LoginPresenter(var view: LoginContract.View) : LoginContract.Presenter {
    override fun doLogin(name: String, pwd: String) {
        if (name != null && name.isNotEmpty()) {
            if (pwd != null && pwd.isNotEmpty()) {

            } else view.pwdError()
        } else view.onNameError()
    }

    override fun doRegister(context: Context) {
        context.startActivity(Intent(context, RegisterActivity::class.java))
    }
}