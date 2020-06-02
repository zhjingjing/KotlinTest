package com.zh.kotlin.recycler.chat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.zh.kotlin.R
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    private var list: ArrayList<Message>? = null
    private var chatAdapter: ChatAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        list = arrayListOf()
        chatAdapter = ChatAdapter(this, list!!)
        recycler_chat.layoutManager = LinearLayoutManager(this)
        recycler_chat.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycler_chat.adapter = chatAdapter
        btn_send.setOnClickListener {
            val msg = edit_msg.text.toString()
            if (msg == "") {
                return@setOnClickListener
            }
            val message = Message(list!!.size, msg, (0..1).random())
            Log.e("xxx", message.type.toString())
            list!!.add(message)
            chatAdapter!!.notifyDataSetChanged()
            edit_msg.setText("")
        }
    }

}
