package com.zh.kotlin.recycler

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.zh.kotlin.R
import com.zh.kotlin.utils.GirdItemDecoration
import kotlinx.android.synthetic.main.activity_recycler.*
import java.lang.StringBuilder

class RecyclerActivity : AppCompatActivity() {
    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, RecyclerActivity::class.java))
        }
    }


    private var list: ArrayList<PositionData>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initListener()
        init1()
    }

    private fun initListener() {
        btn_ver.setOnClickListener { init1() }
        btn_grid.setOnClickListener { init2() }
        btn_sta.setOnClickListener { init3() }
    }

    private fun init1() {
        list = arrayListOf()
        repeat(30) {
            list?.add(PositionData("$it"))
        }
        val linearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this)
        val positionAdapter = PositionAdapter(list!!)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = positionAdapter
        recycler_view.addItemDecoration(
            androidx.recyclerview.widget.DividerItemDecoration(
                this,
                androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
            )
        )
    }

    private fun init2() {
        list = arrayListOf()
        repeat(5) {
            list?.add(PositionData("$it"))
        }
        val gridLayoutManager =
            androidx.recyclerview.widget.GridLayoutManager(this, 3)
        val girdAdapter = GirdAdapter(list!!)
        recycler_view.layoutManager = gridLayoutManager
        recycler_view.addItemDecoration(GirdItemDecoration(resources.getDrawable(R.drawable.divider_grid)))
        recycler_view.adapter = girdAdapter
    }

    private fun init3() {
        list = arrayListOf()
        repeat(30) {
            list?.add(PositionData(getName(it)))
        }
        val staManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
            3,
            androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
        )
        val girdAdapter = GirdAdapter(list!!)
        recycler_view.layoutManager = staManager
        recycler_view.adapter = girdAdapter
    }

    private fun getName(s: Int): String {
        val num = (1..20).random()
        val stringBuilder = StringBuilder()
        repeat(num) {
            stringBuilder.append(s)
        }
        return stringBuilder.toString()
    }
}
