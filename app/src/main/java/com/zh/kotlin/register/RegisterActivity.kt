package com.zh.kotlin.register

import com.zh.baselib.base.BaseActivity
import com.zh.kotlin.R
import com.zh.kotlin.register.contract.RegisterContract
import com.zh.kotlin.register.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterContract.View {
    var presenter = RegisterPresenter(this)
    override fun initData() {
        btnRegister.setOnClickListener {
            btnRegister.isClickable = false
            presenter.onRegister(
                editName.text.toString(),
                editPwd.text.toString(),
                editPwdConfirm.text.toString()
            )
        }
    }

    override fun initListener() {

    }

    override fun getLayoutId(): Int = R.layout.activity_register


    override fun onNameError() {
        btnRegister.isClickable = true
        myToast("姓名错误")
    }

    override fun onPwdError() {
        btnRegister.isClickable = true
        myToast("密码错误")
    }

    override fun onPwdConfirmError() {
        btnRegister.isClickable = true
        myToast("确认密码不正确")
    }

    override fun onRegisterSuccess() {
        btnRegister.isClickable = true
        myToast("注册成功")
        finish()
    }

    override fun onRegisterError() {
        btnRegister.isClickable = true
        myToast("注册失败")
    }

    override fun onError(msg: String) {
        btnRegister.isClickable = true
        myToast(msg)
    }

    override fun dismissLoading() {
    }

    override fun showLoading() {
    }

}
