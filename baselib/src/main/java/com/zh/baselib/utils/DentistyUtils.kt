package com.zh.baselib.utils

import android.content.Context
import androidx.annotation.Px

/**
 * create by zj on 2020/7/7
 */
fun dpToPx(context: Context, dp: Float): Float {
    return dp * context.resources.displayMetrics.density
}

fun pxToDp(context: Context,px: Float):Float{
    return px/context.resources.displayMetrics.density
}