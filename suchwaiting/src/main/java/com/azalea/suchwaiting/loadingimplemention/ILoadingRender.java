package com.azalea.suchwaiting.loadingimplemention;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * interface of loading render
 */
public interface ILoadingRender {

	void draw(@NonNull Canvas canvas);

	void setAlpha(@IntRange(from = 0, to = 255) int alpha);

	void setColorFilter(@Nullable ColorFilter colorFilter);

	void onBoundsChange(Rect bounds);

	int getOpacity();

	int getIntrinsicHeight();

	int getIntrinsicWidth();
}
