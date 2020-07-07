package com.azalea.suchwaiting.wrapper_drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * base loading drawable
 */
public class LoadingDrawable extends Drawable implements Drawable.Callback {

	BaseLoadingRender mLoadingRender = null;

	public LoadingDrawable(BaseLoadingRender loadingRender) {
		mLoadingRender = loadingRender;
		mLoadingRender.setDrawableCallBack(this);
	}

	@Override
	public void draw(@NonNull Canvas canvas) {
		mLoadingRender.draw(canvas);
	}

	@Override
	public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
		mLoadingRender.setAlpha(alpha);
	}

	@Override
	public void setColorFilter(@Nullable ColorFilter colorFilter) {
		mLoadingRender.setColorFilter(colorFilter);
	}

	@Override
	protected void onBoundsChange(Rect bounds) {
		super.onBoundsChange(bounds);
		mLoadingRender.onBoundsChange(bounds);
	}

	@Override
	public int getOpacity() {
		return mLoadingRender.getOpacity();
	}

	@Override
	public void invalidateDrawable(@NonNull Drawable who) {
		invalidateSelf();
	}

	@Override
	public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {
		scheduleSelf(what, when);
	}

	@Override
	public int getIntrinsicHeight() {
		return mLoadingRender.getIntrinsicHeight();
	}

	@Override
	public int getIntrinsicWidth() {
		return mLoadingRender.getIntrinsicWidth();
	}

	@Override
	public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {
		unscheduleSelf(what);
	}
}
