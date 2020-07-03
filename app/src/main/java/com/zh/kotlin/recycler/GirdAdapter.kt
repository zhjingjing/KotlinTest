package com.zh.kotlin.recycler

import android.content.Context
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
class GirdAdapter : BaseListAdapter<PositionData, GirdAdapter.GridHolder>() {

    override fun getItemCount(): Int {
        return list?.size
    }

    inner class GridHolder(view: View) : BaseListHolder(view) {
        val name: TextView = view.findViewById(R.id.item_tv_name)
        val avatar: ImageView = view.findViewById(R.id.item_iv_avatar)
    }

    override fun refreshData(holder: GridHolder, data: PositionData, position: Int) {
        holder.name.text = data.name
        holder.avatar.setImageResource(data.imgId)
    }

    override fun getItemHolder(parent: ViewGroup?): BaseListHolder {
        return GridHolder(
            LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_user_grid_values, parent, false)
        )
    }

}