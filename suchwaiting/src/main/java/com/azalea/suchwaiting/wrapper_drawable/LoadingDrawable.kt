package com.azalea.suchwaiting.wrapper_drawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.annotation.IntRange
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender

/**
 * base loading drawable
 */
class LoadingDrawable(private val mLoadingRender: BaseLoadingRender) : Drawable(), Drawable.Callback {

    init {
        mLoadingRender.setDrawableCallBack(this, this)
        setVisible(visible = false, restart = false)
    }

    override fun setVisible(visible: Boolean, restart: Boolean): Boolean {
        val changed = super.setVisible(visible, restart)
        if (changed) {
            mLoadingRender.setVisible(visible)
        }
        return changed
    }

    override fun draw(canvas: Canvas) {
        mLoadingRender.draw(canvas)
    }

    override fun setAlpha(@IntRange(from = 0, to = 255) alpha: Int) {
        mLoadingRender.setAlpha(alpha)
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mLoadingRender.setColorFilter(colorFilter)
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        mLoadingRender.onBoundsChange(bounds)
    }

    override fun getOpacity(): Int {
        return mLoadingRender.opacity
    }

    override fun invalidateDrawable(who: Drawable) {
        invalidateSelf()
    }

    override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
        scheduleSelf(what, `when`)
    }

    override fun getIntrinsicHeight(): Int {
        return mLoadingRender.intrinsicHeight
    }

    override fun getIntrinsicWidth(): Int {
        return mLoadingRender.intrinsicWidth
    }

    override fun unscheduleDrawable(who: Drawable, what: Runnable) {
        unscheduleSelf(what)
    }
}