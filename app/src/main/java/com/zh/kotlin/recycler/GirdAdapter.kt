package com.zh.kotlin.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zh.kotlin.R

/**
 * create by zj on 2020/5/14
 *
 */
class GirdAdapter(private val list: ArrayList<PositionData>) : RecyclerView.Adapter<GirdAdapter.GirdHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GirdHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_user_grid_values, p0, false)
        return GirdHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: GirdHolder, p1: Int) {
        val data = list[p1]
        p0.name.text = data.name
        p0.avatar.setImageResource(data.imgId)
    }

    inner class GirdHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_tv_name)
        val avatar: ImageView = view.findViewById(R.id.item_iv_avatar)
    }

}