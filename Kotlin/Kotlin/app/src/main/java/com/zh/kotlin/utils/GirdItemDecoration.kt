package com.zh.kotlin.utils

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * create by zj on 2020/5/14
 * GirdLayoutManager的分割线
 */
class GirdItemDecoration(private val drawable: Drawable) : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.layoutManager !is GridLayoutManager) {
            return
        }
        val count = parent.childCount//获取子view个数
        val spanCount = (parent.layoutManager as GridLayoutManager).spanCount
        val orientation = (parent.layoutManager as GridLayoutManager).orientation

        var isDrawHor: Boolean = false
        var isDrawVer: Boolean = false
        var extra: Int = if (count % spanCount == 0) {
            spanCount
        } else {
            count % spanCount
        }

        for (i in 0 until count) {
            isDrawHor = true
            isDrawVer = true

            if (orientation == GridLayoutManager.VERTICAL && (i + 1) % spanCount == 0) {
                isDrawVer = false
            }
            if (orientation == GridLayoutManager.VERTICAL && i >= (count - extra)) {
                isDrawHor = false
            }

            if (orientation == GridLayoutManager.HORIZONTAL && (i + 1) % spanCount == 0) {
                isDrawHor = false
            }
            if (orientation == GridLayoutManager.HORIZONTAL && i >= (count - extra)) {
                isDrawVer = false
            }
            if (isDrawHor) {
                drawHor(c, parent, i)
            }
            if (isDrawVer) {
                drawVer(c, parent, i)
            }

        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.layoutManager is GridLayoutManager) {
            val spanCount = (parent.layoutManager as GridLayoutManager).spanCount
            val orientation = (parent.layoutManager as GridLayoutManager).orientation
            val pos = parent.getChildLayoutPosition(view)

            if (orientation == GridLayoutManager.VERTICAL && (pos + 1) % spanCount == 0) {
                outRect.set(0, 0, 0, drawable.intrinsicHeight)
                return
            }

            if (orientation == GridLayoutManager.HORIZONTAL && (pos + 1) % spanCount == 0) {
                outRect.set(0, 0, drawable.intrinsicWidth, 0)
                return
            }
            outRect.set(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        }
    }

    private fun drawHor(c: Canvas, parent: RecyclerView, pos: Int) {
        val view = parent.getChildAt(pos)
        val layoutParams = view.layoutParams as RecyclerView.LayoutParams

        val top = view.bottom + layoutParams.topMargin
        val bottom = top + drawable.intrinsicHeight
        val start = view.left - layoutParams.marginStart
        val end = view.right + layoutParams.marginEnd
        drawable.setBounds(start, top, end, bottom)
        drawable.draw(c)
    }

    private fun drawVer(c: Canvas, parent: RecyclerView, pos: Int) {
        val view = parent.getChildAt(pos)
        val layoutParams = view.layoutParams as RecyclerView.LayoutParams

        val top = view.top - layoutParams.topMargin
        val bottom = view.bottom + layoutParams.bottomMargin + drawable.intrinsicHeight
        val start = view.right + layoutParams.rightMargin
        val end = start + drawable.intrinsicWidth
        drawable.setBounds(start, top, end, bottom)
        drawable.draw(c)
    }
}
