package com.azalea.suchwaiting.wrapper_drawable

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar
import com.azalea.suchwaiting.loadingimplemention.dotloading.DotLoadingDrawable

/**
 * @author PG.Xie
 * created on 2020/7/7
 */


class LoadingBar : ProgressBar {

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
//        if (attrs != null) {
//            val resource = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0)
//            indeterminateDrawable = resources.getDrawable(resource)
//        }
        isIndeterminate = true
        indeterminateDrawable = DotLoadingDrawable()
    }
}