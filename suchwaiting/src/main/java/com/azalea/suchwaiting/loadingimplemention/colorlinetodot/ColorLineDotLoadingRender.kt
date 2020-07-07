package com.azalea.suchwaiting.loadingimplemention.colorlinetodot

import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.animation.LinearInterpolator
import com.azalea.suchwaiting.exception.UnsupportedValueSetException
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender

/**
 * color line dot loading render
 */
class ColorLineDotLoadingRender : BaseLoadingRender, AnimatorUpdateListener {

    private var mDegree = 0
    private var mBounds = Rect()
    private val mPaint = Paint()
    private lateinit var mAnimator: ValueAnimator
    private var mDrawableColor = Color.parseColor("#FDFDFE")
    private var mDuration = 1600L

    constructor() {
        init()
    }

    constructor(duration: Long) {
        if (duration <= 0) {
            throw UnsupportedValueSetException("you must set a duration greater than zero")
        }
        mDuration = duration
        init()
    }

    constructor(duration: Long, colorYouLike: Int) {
        if (duration <= 0) {
            throw UnsupportedValueSetException("you must set a duration greater than zero")
        }
        mDuration = duration
        mDrawableColor = colorYouLike
        init()
    }

    private fun init() {

        mAnimator = ValueAnimator.ofInt(0, 360).also {
            it.duration = mDuration
            it.repeatCount = ValueAnimator.INFINITE
            it.interpolator = LinearInterpolator()
            it.addUpdateListener(this@ColorLineDotLoadingRender)
        }

        mPaint.color = mDrawableColor
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.isAntiAlias = true
    }

    override fun draw(canvas: Canvas) {
        drawCircle(canvas, mDegree)
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        mBounds = bounds
    }

    override fun setVisible(visible: Boolean) {
        if (visible) {
            mAnimator.start()
        } else {
            mAnimator.cancel()
        }
    }

    private fun drawCircle(canvas: Canvas, degree: Int) {
        val outWidth = mBounds.width()
        val outHeight = mBounds.height()
        val innerWidth: Float = (outWidth * SIZE_RATIO)
        val innerHeight: Float = (outHeight * SIZE_RATIO)
        val realMinSize = innerWidth.coerceAtMost(innerHeight)
        val realSize = if (realMinSize > MAX_SIZE) MAX_SIZE.toFloat() else realMinSize
        val innerCentX = outWidth / 2.toFloat()
        val innerCentY = outHeight / 2.toFloat()
        val diameter = realSize / 10f
        val maxLenth = realSize / 6f
        val disUnit = maxLenth / 10f
        mPaint.strokeWidth = diameter
        for (i in 0..10) {
            val distanceForOriginStart = disUnit * i
            canvas.save()
            canvas.rotate(-i * 30 + degree.toFloat(), innerCentX, innerCentY)
            canvas.drawLine(innerCentX + (realSize / 2 - maxLenth - diameter) + distanceForOriginStart, innerCentY, outWidth - (outWidth - realSize) / 2 - diameter, innerCentY, mPaint)
            canvas.restore()
        }
    }

    override fun onAnimationUpdate(animation: ValueAnimator) {
        mDegree = animation.animatedValue as Int
        invalidate()
    }

    private val MAX_SIZE = 480
    private val SIZE_RATIO = 0.16f
}