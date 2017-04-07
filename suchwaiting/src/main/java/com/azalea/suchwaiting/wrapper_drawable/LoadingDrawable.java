package com.azalea.suchwaiting.wrapper_drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.MarginLayoutParamsCompat;

import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;
import com.azalea.suchwaiting.loadingimplemention.ILoadingRender;


/**
 * base loading drawable
 */
public class LoadingDrawable extends Drawable {

	BaseLoadingRender mLoadingRender = null;

	public LoadingDrawable(BaseLoadingRender loadingRender) {
		mLoadingRender = loadingRender;
		mLoadingRender.setDrawableCallBack(this.getCallback());
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
}
