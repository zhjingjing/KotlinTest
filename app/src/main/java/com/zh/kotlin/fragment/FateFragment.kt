package com.zh.kotlin.fragment

import android.view.View
import com.zh.baselib.base.BaseFragment
import com.zh.kotlin.R

/**
 * create by zj on 2020/5/15
 */
class FateFragment : BaseFragment() {
    override fun getLayoutId(): View? {
        return layoutInflater.inflate(R.layout.fragment_first, null, false)
    }

}