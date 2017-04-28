package azalea.com.suchwating.sample;

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
				new TriangleShrinkDotRender(),
				new TriangleShrinkDotRender(),
				new TriangleShrinkDotRender(),
				new TriangleShrinkDotRender(),
		};
	}
}
