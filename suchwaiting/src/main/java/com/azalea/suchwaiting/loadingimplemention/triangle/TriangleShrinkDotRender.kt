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
 * Triangle Shrink Dot render
 */
class TriangleShrinkDotRender : BaseLoadingRender {

    private val MAX_SIZE = 480
    private val SIZE_RATIO = 0.24f
    private val DEFAULT_COLOR = Color.parseColor("#0084ff")

    private val mPaint = Paint()
    private var mRealSize = 0f
    private var mDotCircleRadius = 0f
    private var mModelCircleRadius = 0f
    private var mCentX = 0f
    private var mCentY = 0f
    private var mStartX = 0f
    private var mStartY = 0f
    private var mEndX = 0f
    private var mEndY = 0f
    private var mDegree = 0
    private var mCurrentShrinkDot = 0
    private var mCurrentShrinkOffset = 0
    private lateinit var mAnimator: ValueAnimator
    private lateinit var mShinkAnimator: ValueAnimator
    private var mRotateDuration = 1800L
    private var mShrinkDuration = 900L
    private var mColor = DEFAULT_COLOR

    constructor() {
        init()
    }

    constructor(color: Int) {
        mColor = color
        init()
    }

    constructor(rotateDuration: Long, shrinkDuration: Long, color: Int) {
        mRotateDuration = rotateDuration
        mShrinkDuration = shrinkDuration
        mColor = color
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
            it.addUpdateListener(AnimatorUpdateListener { animation ->
                mDegree = animation.animatedValue as Int
                invalidate()
            })
        }

        mShinkAnimator = ValueAnimator.ofInt(0, 299).also {

            it.duration = mShrinkDuration * 3
            it.repeatCount = ValueAnimator.INFINITE
            it.interpolator = LinearInterpolator()
            it.addUpdateListener(AnimatorUpdateListener { animation ->
                val value = animation.animatedValue as Int
                mCurrentShrinkDot = value / 100
                mCurrentShrinkOffset = value % 100
                invalidate()
            })
        }
    }

    override fun draw(canvas: Canvas) {
        drawTriangle(canvas, mDegree)
    }

    private fun drawTriangle(canvas: Canvas, degree: Int) {
        val endDot = if (mCurrentShrinkDot == 0) 2 else mCurrentShrinkDot - 1
        val moveRatio = if (mCurrentShrinkOffset < 50) mCurrentShrinkOffset.toFloat() else 100 - mCurrentShrinkOffset.toFloat()
        val currentMoveOffset = mModelCircleRadius * moveRatio / 50
        val lastDotEndXOffset = ((mModelCircleRadius - currentMoveOffset) * Math.cos(Math.PI / 6)).toFloat()
        val lastDotEndYOffset = ((mModelCircleRadius - currentMoveOffset) * Math.sin(Math.PI / 6)).toFloat()
        for (i in 0..2) {
            canvas.save()
            val startX = mStartX
            var startY = mStartY
            var endX = mEndX
            var endY = mEndY
            if (mCurrentShrinkDot == i) {
                startY += currentMoveOffset
            }
            if (endDot == i) {
                endX = mCentX + lastDotEndXOffset
                endY = mCentY + lastDotEndYOffset
            }
            canvas.rotate(i * 120 + degree.toFloat(), mCentX, mCentY)
            canvas.drawCircle(startX, startY, mDotCircleRadius, mPaint)
            canvas.drawLine(startX, startY, endX, endY, mPaint)
            canvas.restore()
        }
    }

    override fun onBoundsChange(bounds: Rect) {
        val innerWidth: Float = (bounds.width() * SIZE_RATIO)
        val innerHeight: Float = (bounds.height() * SIZE_RATIO)
        val realMinSize = Math.min(innerWidth, innerHeight)
        mRealSize = if (realMinSize > MAX_SIZE) MAX_SIZE.toFloat() else realMinSize
        mModelCircleRadius = mRealSize / 2
        mDotCircleRadius = mRealSize * 0.1f
        mCentX = bounds.width() / 2f
        mCentY = bounds.height() / 2f
        mStartX = mCentX
        mStartY = mCentY - mRealSize / 2f
        mEndY = mStartY + 0.75f * mRealSize
        mEndX = mStartX + (0.75f * mRealSize * Math.tan(Math.PI / 6)).toFloat()
    }

    override fun setVisible(visible: Boolean) {
        if (visible) {
            mAnimator.start()
            mShinkAnimator.start()
        } else {
            mAnimator.cancel()
            mShinkAnimator.cancel()
        }
    }
}