package com.zh.baselib.ext

import com.zh.baselib.base.BaseApp
import com.zh.baselib.utils.dpToPx
import com.zh.baselib.utils.pxToDp

/**
 * create by zj on 2020/7/7
 */
fun Float.toPx() = dpToPx(BaseApp.instance, this)
fun Float.toDp() = pxToDp(BaseApp.instance, this)