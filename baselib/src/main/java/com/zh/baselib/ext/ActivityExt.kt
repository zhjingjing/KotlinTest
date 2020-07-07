package com.zh.baselib.ext

import android.app.Activity
import android.graphics.Color
import android.view.View.*

/**
 * create by zj on 2020/7/7
 */
fun Activity.immersiveSystemUi(light: Boolean = true) {
    window.run {
        var mode = if (light) SYSTEM_UI_FLAG_LIGHT_STATUS_BAR else SYSTEM_UI_FLAG_LAYOUT_STABLE
        decorView.systemUiVisibility = SYSTEM_UI_FLAG_HIDE_NAVIGATION or mode
        statusBarColor = Color.TRANSPARENT
        navigationBarColor = Color.TRANSPARENT
    }
}

fun Activity.setNavigationBarColor(color: Int) {
    window.navigationBarColor = color
}

fun Activity.setStatusBarColor(color: Int) {
    window.statusBarColor = color
}

fun Activity.getLight(): Float {
    return window.attributes.screenBrightness
}

fun Activity.setLight(light: Float) {
    window.attributes.screenBrightness = light
}