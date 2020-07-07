package com.zh.baselib.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast

/**
 * create by zj on 2020/7/7
 */
fun Context.shortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.copyTextIntoClipBroad(text: CharSequence?, label: String?) {
    if (text.isNullOrEmpty()) return
    var s =
        applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager ?: return

    s.setPrimaryClip(ClipData.newPlainText(label, text))
}