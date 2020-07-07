package azalea.com.suchwating.sample

import android.graphics.Color
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender
import com.azalea.suchwaiting.loadingimplemention.triangle.TriangleDotRender

/**
 * 普通三角形sample
 */
class TriangleFragment : FiveLoadRenderFragment() {
    override val fiveLoadingRender: Array<BaseLoadingRender> = arrayOf(
            TriangleDotRender(),
            TriangleDotRender(3000L, Color.BLUE),
            TriangleDotRender(1000L, Color.RED),
            TriangleDotRender(400L, Color.parseColor("#00c300")),
            TriangleDotRender(6000L, Color.YELLOW))
}