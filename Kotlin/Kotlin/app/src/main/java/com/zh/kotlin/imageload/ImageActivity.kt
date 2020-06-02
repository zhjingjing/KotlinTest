package com.zh.kotlin.imageload

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import coil.api.load
import com.zh.kotlin.R
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, ImageActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        iv_test1.load("https://www.google.com/url?sa=i&url=https%3A%2F%2F699pic.com%2Ftupian-400110709.html&psig=AOvVaw2oydv_OjDdj6uSGVtiLi98&ust=1589620691532000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIjl5dfEtekCFQAAAAAdAAAAABAD") {

        }
    }
}
