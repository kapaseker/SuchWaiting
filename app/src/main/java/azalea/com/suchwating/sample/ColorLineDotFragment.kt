package azalea.com.suchwating.sample

import android.graphics.Color
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender
import com.azalea.suchwaiting.loadingimplemention.colorlinetodot.ColorLineDotLoadingRender

/**
 * 线点渐进变换sample
 */
class ColorLineDotFragment : FiveLoadRenderFragment() {
    override val fiveLoadingRender: Array<BaseLoadingRender> = arrayOf(ColorLineDotLoadingRender(1000L, Color.RED),
            ColorLineDotLoadingRender(2600L, Color.BLUE),
            ColorLineDotLoadingRender(),
            ColorLineDotLoadingRender(3000L, Color.parseColor("#00c300")),
            ColorLineDotLoadingRender(2600L, Color.MAGENTA))
}