package com.azalea.suchwaiting.loadingimplemention.dotloading

import android.graphics.*
import android.graphics.drawable.Drawable

/**
 * @author PG.Xie
 * created on 2020/7/7
 */

class DotLoadingDrawable : Drawable {

    private val MAX_LEVEL = 10000;
    private val DEF_OPACITY = 0
    private var mBound: Rect = Rect(0, 0, 48, 48)
    private var mColorRatio = 0

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor() : super() {
        mPaint.color = Color.RED
        mPaint.strokeWidth = 6F
        mPaint.style = Paint.Style.STROKE
    }

    override fun draw(canvas: Canvas) {
//        canvas.drawColor(Color.green(mGreenColor))
        mPaint.color = mColorRatio or 0xff000000.toInt()
        canvas.drawCircle(mBound.width().toFloat() / 2, mBound.height().toFloat() / 2, 60F, mPaint)
    }

    /**
     * from=0,to=10000
     */
    override fun onLevelChange(level: Int): Boolean {
        mColorRatio = (level.toFloat() / MAX_LEVEL * 255).toInt()
        return true
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        mBound = bounds
    }

    override fun setAlpha(alpha: Int) {

    }

    override fun getOpacity() = DEF_OPACITY

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

    override fun getIntrinsicHeight(): Int {
        return 48
    }

    override fun getIntrinsicWidth(): Int {
        return 48
    }
}