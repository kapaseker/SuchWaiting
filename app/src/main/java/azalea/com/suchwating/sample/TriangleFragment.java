package azalea.com.suchwating.sample;

import android.graphics.Color;

import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;
import com.azalea.suchwaiting.loadingimplemention.triangle.TriangleDotRender;


/**
 * 普通三角形sample
 */
public class TriangleFragment extends FiveLoadRenderFragment {

	@Override
	protected BaseLoadingRender[] getFiveLoadingRender() {
		return new BaseLoadingRender[]{
				new TriangleDotRender(),
				new TriangleDotRender(3000L, Color.BLUE),
				new TriangleDotRender(Color.RED),
				new TriangleDotRender(2000L, Color.parseColor("#00c300")),
				new TriangleDotRender(Color.YELLOW),
		};
	}
}
