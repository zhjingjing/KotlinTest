package com.zh.kotlin.register.contract

import com.zh.baselib.base.BasePresenter
import com.zh.baselib.base.BaseView

/**
 * create by zj on 2020/7/3
 */
interface RegisterContract {
    interface Presenter : BasePresenter<View> {
        fun onRegister(name: String, pwd: String, pwdConfirm: String)
    }

    interface View : BaseView {
        fun onNameError()
        fun onPwdError()
        fun onPwdConfirmError()
        fun onRegisterSuccess()
        fun onRegisterError()
    }
}