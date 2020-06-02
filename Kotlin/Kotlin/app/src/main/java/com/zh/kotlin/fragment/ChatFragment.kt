package com.zh.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zh.kotlin.R

/**
 * create by zj on 2020/5/15
 */
class ChatFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return layoutInflater.inflate(R.layout.fragment_chat, container, false)
    }
}