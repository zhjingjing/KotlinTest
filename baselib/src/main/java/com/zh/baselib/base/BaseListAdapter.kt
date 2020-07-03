package com.zh.baselib.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * create by zj on 2020/7/3
 */
abstract class BaseListAdapter<T, V : BaseListAdapter.BaseListHolder> :
    RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {
    var list = ArrayList<T>()

    fun updateList(list: ArrayList<T>) {
        this.list = list
        notifyDataSetChanged()
    }


    open class BaseListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListHolder {
        return getItemHolder(parent)
    }

    abstract fun getItemHolder(parent: ViewGroup?): BaseListHolder

    abstract fun refreshData(holder: V, data: T, position: Int)

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        refreshData(holder as V, list?.get(position), position)
    }
}