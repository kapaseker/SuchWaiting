package azalea.com.suchwating.sample;

import android.graphics.Color;

import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;
import com.azalea.suchwaiting.loadingimplemention.triangle.TriangleShrinkDotRender;


/**
 * 三角收缩点sample
 */
public class TriangleShrinkDotFragment extends FiveLoadRenderFragment {

	@Override
	protected BaseLoadingRender[] getFiveLoadingRender() {
		return new BaseLoadingRender[]{
				new TriangleShrinkDotRender(),
				new TriangleShrinkDotRender(Color.RED),
				new TriangleShrinkDotRender(1400L,400L,Color.BLUE),
				new TriangleShrinkDotRender(2400L,600L,Color.GREEN),
				new TriangleShrinkDotRender(1200L,400L,Color.YELLOW),
		};
	}
}
