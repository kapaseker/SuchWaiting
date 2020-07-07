package com.azalea.suchwaiting.loadingimplemention.triangle

import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.animation.LinearInterpolator
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender

/**
 * triangle dot render
 */
class TriangleDotRender : BaseLoadingRender, AnimatorUpdateListener {

    private val MAX_SIZE = 480
    private val SIZE_RATIO = 0.18f
    private val DEFAULT_COLOR = Color.parseColor("#0084ff")

    private val mPaint = Paint()
    private var mRealSize = 0f
    private var mCircleRadius = 0f
    private var mCentX = 0f
    private var mCentY = 0f
    private var mStartX = 0f
    private var mStartY = 0f
    private var mEndX = 0f
    private var mEndY = 0f
    private var mDegree = 0
    private lateinit var mAnimator: ValueAnimator
    private var mRotateDuration = 1800L
    private var mColor = DEFAULT_COLOR

    constructor() {
        init()
    }

    constructor(mColor: Int) {
        this.mColor = mColor
        init()
    }

    constructor(mRotateDuration: Long) {
        this.mRotateDuration = mRotateDuration
        init()
    }

    constructor(mRotateDuration: Long, mColor: Int) {
        this.mRotateDuration = mRotateDuration
        this.mColor = mColor
        init()
    }

    private fun init() {
        mPaint.isAntiAlias = true
        mPaint.color = mColor
        mPaint.strokeWidth = 1f

        mAnimator = ValueAnimator.ofInt(0, 360).also {
            it.duration = mRotateDuration
            it.repeatCount = ValueAnimator.INFINITE
            it.interpolator = LinearInterpolator()
            it.addUpdateListener(this)
        }
    }

    override fun draw(canvas: Canvas) {
        drawTriangle(canvas, mDegree)
    }

    private fun drawTriangle(canvas: Canvas, degree: Int) {
        var i = 0
        while (i < 360) {
            canvas.save()
            canvas.rotate(i + degree.toFloat(), mCentX, mCentY)
            canvas.drawCircle(mStartX, mStartY, mCircleRadius, mPaint)
            canvas.drawLine(mStartX, mStartY, mEndX, mEndY, mPaint)
            canvas.restore()
            i += 120
        }
    }

    override fun onBoundsChange(bounds: Rect) {
        val innerWidth: Float = (bounds.width() * SIZE_RATIO)
        val innerHeight: Float = (bounds.height() * SIZE_RATIO)
        val realMinSize = innerWidth.coerceAtMost(innerHeight)
        mRealSize = if (realMinSize > MAX_SIZE) MAX_SIZE.toFloat() else realMinSize
        mCircleRadius = mRealSize * 0.13f
        mCentX = bounds.width() / 2f
        mCentY = bounds.height() / 2f
        mStartX = mCentX
        mStartY = mCentY - mRealSize / 2f
        mEndY = mStartY + 0.75f * mRealSize
        mEndX = mStartX + (0.75f * mRealSize * Math.tan(Math.PI / 6)).toFloat()
    }

    override fun setVisible(visible: Boolean) {
        if (visible) {
            mAnimator?.start()
        } else {
            mAnimator?.cancel()
        }
    }

    override fun onAnimationUpdate(animation: ValueAnimator) {
        mDegree = animation.animatedValue as Int
        invalidate()
    }
}