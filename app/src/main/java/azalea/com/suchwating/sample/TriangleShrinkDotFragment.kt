package azalea.com.suchwating.sample

import android.graphics.Color
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender
import com.azalea.suchwaiting.loadingimplemention.triangle.TriangleShrinkDotRender

/**
 * 三角收缩点sample
 */
class TriangleShrinkDotFragment : FiveLoadRenderFragment() {
    override val fiveLoadingRender: Array<BaseLoadingRender> = arrayOf(
            TriangleShrinkDotRender(),
            TriangleShrinkDotRender(600L, 2000L, Color.RED),
            TriangleShrinkDotRender(6000L, 400L, Color.BLUE),
            TriangleShrinkDotRender(2400L, 600L, Color.GREEN),
            TriangleShrinkDotRender(1200L, 400L, Color.BLACK))
}