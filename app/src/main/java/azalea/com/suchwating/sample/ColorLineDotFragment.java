package azalea.com.suchwating.sample;

import android.graphics.Color;

import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;
import com.azalea.suchwaiting.loadingimplemention.colorlinetodot.ColorLineDotLoadingRender;

/**
 * 线点渐进变换sample
 */
public class ColorLineDotFragment extends FiveLoadRenderFragment {

	@Override
	protected BaseLoadingRender[] getFiveLoadingRender() {
		return new BaseLoadingRender[]{new ColorLineDotLoadingRender(1000L, Color.RED),
				new ColorLineDotLoadingRender(2600L, Color.BLUE),
				new ColorLineDotLoadingRender(),
				new ColorLineDotLoadingRender(3000L, Color.parseColor("#00c300")),
				new ColorLineDotLoadingRender(2600L, Color.MAGENTA),
		};
	}
}
