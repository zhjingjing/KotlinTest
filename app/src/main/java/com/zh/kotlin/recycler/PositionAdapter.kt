package com.zh.kotlin.recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zh.baselib.base.BaseListAdapter
import com.zh.kotlin.R

/**
 * create by zj on 2020/5/14
 *
 */
class PositionAdapter : BaseListAdapter<PositionData, PositionAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return list?.size
    }

    inner class ViewHolder(view: View) :
        BaseListHolder(view) {
        val name: TextView = view.findViewById(R.id.item_tv_name)
        val avatar: ImageView = view.findViewById(R.id.item_iv_avatar)
    }

    override fun refreshData(holder: ViewHolder, data: PositionData, position: Int) {
        Log.e("xx", "{$position}===${data.name}}")
        holder.name.text = data.name
        holder.avatar.setImageResource(data.imgId)
    }

    override fun getItemHolder(parent: ViewGroup?): BaseListHolder {
        return ViewHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.item_user_values, parent, false)
        )
    }

}