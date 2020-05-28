package com.zh.kotlin.imageload

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.google.android.material.tabs.TabLayout
import com.zh.kotlin.R
import com.zh.kotlin.utils.CoilUtils
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    private val url =
        "https://raw.githubusercontent.com/zhjingjing/MySourceInfo/master/QQ%E5%9B%BE%E7%89%8720191021142512.jpg"
    private val videoUrl =
        "https://cdn.tikas.in//video//video_skill//20200505//337e88ab7c44412090a1cbb29c519234.mp4"

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, ImageActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        iv_test1.load(R.mipmap.ic_launcher)
        iv_test2.load(url)
        CoilUtils.loadRounderImg(iv_test3, url, 15f)
        CoilUtils.loadBlurImg(this, iv_test3, url, 15f, 15f)
        CoilUtils.loadCircleImg(iv_test4, url)

    }
}
