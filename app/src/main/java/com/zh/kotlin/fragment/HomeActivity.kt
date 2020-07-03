package com.zh.kotlin.fragment

import android.content.Context
import android.content.Intent
import com.zh.baselib.base.BaseActivity
import com.zh.kotlin.R
import kotlinx.android.synthetic.main.activity_fragment.*

class HomeActivity : BaseActivity() {

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_fragment

    override fun initData() {
        changeTab(0)
    }

    override fun initListener() {
        tab_home.setOnClickListener {
            changeTab(0)
        }
        tab_fate.setOnClickListener {
            changeTab(1)

        }
        tab_chat.setOnClickListener {
            changeTab(2)

        }
        tab_me.setOnClickListener {
            changeTab(3)

        }
    }


    override fun onError(msg: String) {
        myToast(msg)
    }

    override fun dismissLoading() {
    }

    override fun showLoading() {
    }

    private fun changeTab(pos: Int) {
        when (pos) {
            0 -> tab_home.setTextColor(resources.getColor(R.color.colorAccent))
            else -> tab_home.setTextColor(resources.getColor(R.color.colorPrimary))
        }
        when (pos) {
            1 -> tab_fate.setTextColor(resources.getColor(R.color.colorAccent))
            else -> tab_fate.setTextColor(resources.getColor(R.color.colorPrimary))
        }
        when (pos) {
            2 -> tab_chat.setTextColor(resources.getColor(R.color.colorAccent))
            else -> tab_chat.setTextColor(resources.getColor(R.color.colorPrimary))
        }
        when (pos) {
            3 -> tab_me.setTextColor(resources.getColor(R.color.colorAccent))
            else -> tab_me.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        when (pos) {
            0 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            1 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FateFragment()).commit()
            2 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ChatFragment()).commit()
            3 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MeFragment()).commit()
        }
    }


}
