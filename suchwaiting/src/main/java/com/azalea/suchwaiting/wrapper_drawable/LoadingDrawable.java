package com.azalea.suchwaiting.wrapper_drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Panoo on 2017/3/28.
 */

public class LoadingDrawable extends Drawable {
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
	public int getOpacity() {
		return 0;
	}
}
