package com.azalea.suchwaiting.loadingimplemention.triangle;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;

import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;


/**
 * triangle dot render
 */
public class TriangleDotRender extends BaseLoadingRender implements ValueAnimator.AnimatorUpdateListener {

	private Paint mPaint = new Paint();
	private static final int MAX_SIZE = 480;
	private static final float SIZE_RATIO = 0.18F;
	private static final int DEFAULT_COLOR = Color.parseColor("#0084ff");

	private float mRealSize = 0F;
	private float mCircleRadius = 0F;
	private float mCentX = 0F;
	private float mCentY = 0F;
	private float mStartX = 0F;
	private float mStartY = 0F;
	private float mEndX = 0F;
	private float mEndY = 0F;
	private int mDegree = 0;
	private ValueAnimator mAnimator = null;

	private long mRotateDuration = 1800L;
	private int mColor = DEFAULT_COLOR;

	public TriangleDotRender() {
		init();
	}

	public TriangleDotRender(int mColor) {
		this.mColor = mColor;
		init();
	}

	public TriangleDotRender(long mRotateDuration) {
		this.mRotateDuration = mRotateDuration;
		init();
	}

	public TriangleDotRender(long mRotateDuration, int mColor) {
		this.mRotateDuration = mRotateDuration;
		this.mColor = mColor;
		init();
	}

	private void init() {
		mPaint.setAntiAlias(true);
		mPaint.setColor(mColor);
		mPaint.setStrokeWidth(1);
	}

	@Override
	public void draw(@NonNull Canvas canvas) {

		if (mAnimator == null) {
			mAnimator = ValueAnimator.ofInt(0, 360);
			mAnimator.setDuration(mRotateDuration);
			mAnimator.setRepeatCount(ValueAnimator.INFINITE);
			mAnimator.setInterpolator(new LinearInterpolator());
			mAnimator.addUpdateListener(this);
			mAnimator.start();
		}

		drawTriangle(canvas, mDegree);
	}

	private void drawTriangle(Canvas canvas, int degree) {


		for (int i = 0; i < 360; i += 120) {
			canvas.save();
			canvas.rotate(i + degree, mCentX, mCentY);
			canvas.drawCircle(mStartX, mStartY, mCircleRadius, mPaint);
			canvas.drawLine(mStartX, mStartY, mEndX, mEndY, mPaint);
			canvas.restore();
		}

	}


	@Override
	public void onBoundsChange(Rect bounds) {

		float innerWidth = (int) (bounds.width() * SIZE_RATIO);
		float innerHeight = (int) (bounds.height() * SIZE_RATIO);

		float realMinSize = Math.min(innerWidth, innerHeight);

		mRealSize = realMinSize > MAX_SIZE ? MAX_SIZE : realMinSize;

		mCircleRadius = mRealSize * 0.13F;

		mCentX = bounds.width() / 2F;
		mCentY = bounds.height() / 2F;

		mStartX = mCentX;
		mStartY = mCentY - mRealSize / 2F;
		mEndY = mStartY + 0.75F * mRealSize;
		mEndX = mStartX + (float) (0.75F * mRealSize * Math.tan(Math.PI / 6));
	}

	@Override
	public void onAnimationUpdate(ValueAnimator animation) {
		mDegree = (int) animation.getAnimatedValue();
		invalidate();
	}
}
