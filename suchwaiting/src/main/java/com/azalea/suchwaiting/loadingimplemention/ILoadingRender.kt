package com.azalea.suchwaiting.loadingimplemention

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Rect
import androidx.annotation.IntRange

/**
 * interface of loading render
 */
interface ILoadingRender {
    fun draw(canvas: Canvas)
    fun setAlpha(@IntRange(from = 0, to = 255) alpha: Int)
    fun setColorFilter(colorFilter: ColorFilter?)
    fun onBoundsChange(bounds: Rect)
    fun setVisible(visible:Boolean)
    val opacity: Int
    val intrinsicHeight: Int
    val intrinsicWidth: Int
}