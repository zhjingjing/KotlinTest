package com.zh.kotlin.recycler.chat

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zh.kotlin.R

/**
 * create by zj on 2020/5/14
 */
class ChatAdapter(private val context: Context, private val chatList: ArrayList<Message>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == Message.TYPE_LEFT) {
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_left, parent, false))
        } else {
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_right, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (chatList != null) {
            if (position < chatList.size && chatList[position].type == Message.TYPE_LEFT) {
                Message.TYPE_LEFT
            } else {
                Message.TYPE_RIGHT
            }

        } else {
            Message.TYPE_LEFT
        }
    }

    override fun getItemCount(): Int {
        return chatList?.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = chatList[position]
        holder.textView.text = message.msg
    }

    inner class ViewHolder(private val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_msg)
    }
}