package com.zh.kotlin.recycler

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zh.kotlin.R
import com.zh.kotlin.recycler.PositionAdapter.*

/**
 * create by zj on 2020/5/14
 *
 */
class PositionAdapter(private val list: ArrayList<PositionData>) : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_user_values, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val data = list[p1]
        p0.name.text = data.name
        p0.avatar.setImageResource(data.imgId)
    }

    inner class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_tv_name)
        val avatar: ImageView = view.findViewById(R.id.item_iv_avatar)
    }

}