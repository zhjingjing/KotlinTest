package com.zh.kotlin.login


import android.content.Intent
import com.zh.baselib.base.BaseActivity
import com.zh.baselib.constant.Constant
import com.zh.kotlin.R
import com.zh.kotlin.fragment.HomeActivity
import com.zh.kotlin.login.contract.LoginContract
import com.zh.kotlin.login.presenter.LoginPresenter
import io.rong.imlib.RongIMClient
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity(), LoginContract.View {
    private val presenter by lazy { LoginPresenter(this) }
    override fun initData() {
        RongIMClient.init(this, Constant.RONG_KEY);
    }

    override fun initListener() {
        btnLogin.setOnClickListener {
            presenter.doLogin(editName.text.toString(), editPwd.text.toString())
        }
        btnJumpRegister.setOnClickListener {
            presenter.doRegister(this)
        }

    }

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun onNameError() {
        myToast("姓名出错")
    }

    override fun pwdError() {
        myToast("密码出错")
    }

    override fun onLoginSuccess() {
        myToast("登录成功")
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onLoginError() {
        myToast("登录失败")
    }

}
