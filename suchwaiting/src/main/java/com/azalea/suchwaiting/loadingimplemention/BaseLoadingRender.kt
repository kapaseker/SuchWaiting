package com.azalea.suchwaiting.loadingimplemention

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.annotation.IntRange
import com.azalea.suchwaiting.contant.DEFAULT_SIZE

/**
 * base render for loading animation , extends this to achieve your own animation.
 */
open abstract class BaseLoadingRender : ILoadingRender {
    private lateinit var mDrawableCallBack: Drawable.Callback
    private lateinit var mDrawable: Drawable

    fun setDrawableCallBack(drawable: Drawable, drawableCallBack: Drawable.Callback) {
        mDrawableCallBack = drawableCallBack
        mDrawable = drawable
    }

    override fun draw(canvas: Canvas) {}
    override fun setAlpha(@IntRange(from = 0, to = 255) alpha: Int) {}
    override fun setColorFilter(colorFilter: ColorFilter?) {}
    override fun onBoundsChange(bounds: Rect) {}
    protected fun invalidate() {
        mDrawableCallBack.invalidateDrawable(mDrawable)
    }

    override val opacity: Int
        get() = PixelFormat.UNKNOWN

    override val intrinsicHeight: Int
        get() = DEFAULT_SIZE

    override val intrinsicWidth: Int
        get() = DEFAULT_SIZE
}