package com.zh.kotlin.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import coil.Coil
import coil.ImageLoader
import coil.api.load
import coil.request.GetRequest
import coil.request.LoadRequest
import coil.size.ViewSizeResolver
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.zh.kotlin.R

/**
 * create by zj on 2020/5/15
 */
object CoilUtils {

    fun loadRounderImg(imageView: ImageView, url: String, rounderSize: Float) {
        imageView.load(url) {
            crossfade(true)
            error(R.drawable.icon_error)
            placeholder(R.mipmap.ic_launcher)
            transformations(
                RoundedCornersTransformation(
                    topRight = rounderSize,
                    topLeft = rounderSize,
                    bottomRight = rounderSize,
                    bottomLeft = rounderSize
                )
            )
        }
    }

    fun loadRounderImg(
        imageView: ImageView,
        url: String,
        rounderSize: Float,
        scaleType: ImageView.ScaleType
    ) {
        imageView.scaleType = scaleType
        imageView.load(url) {
            crossfade(true)
            error(R.drawable.icon_error)
            placeholder(R.mipmap.ic_launcher)
            transformations(
                RoundedCornersTransformation(
                    topRight = rounderSize,
                    topLeft = rounderSize,
                    bottomRight = rounderSize,
                    bottomLeft = rounderSize
                )
            )
        }
    }


    fun loadCircleImg(imageView: ImageView, url: String) {
        imageView.load(url) {
            crossfade(true)
            error(R.drawable.icon_error)
            placeholder(R.mipmap.ic_launcher)
            transformations(CircleCropTransformation())
        }
    }

    //高斯模糊
    fun loadBlurImg(
        context: Context,
        imageView: ImageView,
        url: String,
        radius: Float,
        rounderSize: Float
    ) {
        imageView.load(url) {
            crossfade(true)
            error(R.drawable.icon_error)
            placeholder(R.mipmap.ic_launcher)
            // 模糊radius必须是[0, 25]
            transformations(
                BlurTransformation(context, radius), RoundedCornersTransformation(
                    topRight = rounderSize,
                    topLeft = rounderSize,
                    bottomRight = rounderSize,
                    bottomLeft = rounderSize
                )
            )
        }
    }


}