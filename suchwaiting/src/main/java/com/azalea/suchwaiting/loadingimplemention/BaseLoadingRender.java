package com.azalea.suchwaiting.loadingimplemention;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.azalea.suchwaiting.contant.Constant;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * base render for loading animation , extends this to achieve your own animation.
 */
public class BaseLoadingRender implements ILoadingRender {

	Drawable.Callback mDrawableCallBack = null;

	public void setDrawableCallBack(Drawable.Callback drawableCallBack) {
		mDrawableCallBack = drawableCallBack;
	}

	@Override
	public void draw(@NonNull Canvas canvas) {

	}

	@Override
	public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

	}

	@Override
	public void setColorFilter(@Nullable ColorFilter colorFilter) {

	}

	@Override
	public void onBoundsChange(Rect bounds) {

	}

	protected void invalidate() {
		mDrawableCallBack.invalidateDrawable(null);
	}

	@Override
	public int getOpacity() {
		return PixelFormat.UNKNOWN;
	}

	@Override
	public int getIntrinsicHeight() {
		return Constant.DEFAULT_SIZE;
	}

	@Override
	public int getIntrinsicWidth() {
		return Constant.DEFAULT_SIZE;
	}
}
