package com.azalea.suchwaiting.loadingimplemention.colorlinetodot;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;

import com.azalea.suchwaiting.exception.UnsupportedValueSetException;
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;

import androidx.annotation.NonNull;


/**
 * color line dot loading render
 */
public class ColorLineDotLoadingRender extends BaseLoadingRender implements ValueAnimator.AnimatorUpdateListener {


	private static final int MAX_SIZE = 480;
	private static final float SIZE_RATIO = 0.16F;
	private int mDegree = 0;

	Rect mBounds = new Rect();
	private Paint mPaint = new Paint();
	private ValueAnimator mAnimator = null;

	private int mDrawableColor = Color.parseColor("#FDFDFE");
	private long mDuration = 1600L;

	public ColorLineDotLoadingRender() {

	}

	public ColorLineDotLoadingRender(long duration) {

		if (duration <= 0) {
			throw new UnsupportedValueSetException("you must set a duration greater than zero");
		}

		mDuration = duration;

	}

	public ColorLineDotLoadingRender(long duration, int colorYouLike) {

		if (duration <= 0) {
			throw new UnsupportedValueSetException("you must set a duration greater than zero");
		}

		mDuration = duration;
		mDrawableColor = colorYouLike;
	}


	@Override
	public void draw(@NonNull Canvas canvas) {

		if (mAnimator == null) {
			mAnimator = ValueAnimator.ofInt(0, 360);
			mAnimator.setDuration(mDuration);
			mAnimator.setRepeatCount(ValueAnimator.INFINITE);
			mAnimator.setInterpolator(new LinearInterpolator());
			mAnimator.addUpdateListener(this);
			mAnimator.start();

			mPaint.setColor(mDrawableColor);
			mPaint.setStyle(Paint.Style.STROKE);
			mPaint.setStrokeCap(Paint.Cap.ROUND);
			mPaint.setAntiAlias(true);
		}

		drawCircle(canvas, mDegree);
	}

	@Override
	public void onBoundsChange(Rect bounds) {
		super.onBoundsChange(bounds);
		mBounds = bounds;
	}

	private void drawCircle(Canvas canvas, int degree) {

		int outWidth = mBounds.width();
		int outHeight = mBounds.height();

		float innerWidth = (int) (outWidth * SIZE_RATIO);
		float innerHeight = (int) (outHeight * SIZE_RATIO);

		float realMinSize = Math.min(innerWidth, innerHeight);

		float realSize = realMinSize > MAX_SIZE ? MAX_SIZE : realMinSize;

		float innerCentX = outWidth / 2;
		float innerCentY = outHeight / 2;

		float diameter = realSize / 10f;
		float maxLenth = realSize / 6f;
		float disUnit = maxLenth / 10f;

		mPaint.setStrokeWidth(diameter);

		for (int i = 0; i < 11; ++i) {
			float distanceForOriginStart = disUnit * i;
			canvas.save();
			canvas.rotate(-i * 30 + degree, innerCentX, innerCentY);
			canvas.drawLine(innerCentX + (realSize / 2 - maxLenth - diameter) + distanceForOriginStart, innerCentY, outWidth - (outWidth - realSize) / 2 - diameter, innerCentY, mPaint);
			canvas.restore();
		}
	}

	@Override
	public void onAnimationUpdate(ValueAnimator animation) {
		mDegree = (int) animation.getAnimatedValue();
		invalidate();
	}
}
