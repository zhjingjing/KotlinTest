package com.zh.kotlin.register.presenter

import com.zh.kotlin.register.contract.RegisterContract

/**
 * create by zj on 2020/7/3
 */
class RegisterPresenter(var view: RegisterContract.View) : RegisterContract.Presenter {
    override fun onRegister(name: String, pwd: String, pwdConfirm: String) {
        if (name != null && name.isNotEmpty()) {
            if (pwd != null && pwd.isNotEmpty()) {
                if (pwdConfirm != null && pwdConfirm.isNotEmpty() && pwdConfirm == pwd) {
                    view.onRegisterSuccess()
                } else view.onPwdConfirmError()
            } else view.onPwdError()
        } else view.onNameError()
    }
}