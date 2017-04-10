package azalea.com.suchwating.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.azalea.suchwaiting.loadingimplemention.colorlinetodot.ColorLineDotLoadingRender;
import com.azalea.suchwaiting.wrapper_drawable.LoadingDrawable;

import azalea.com.suchwating.BaseFragment;
import azalea.com.suchwating.R;


public class ColorLineDotFragment extends BaseFragment {

	public static final String TAG_FRAGMENT = "ColorLineDotFragment";

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		((ImageView) view.findViewById(R.id.img_1)).setImageDrawable(new LoadingDrawable(new ColorLineDotLoadingRender(1000L, Color.RED)));
		((ImageView) view.findViewById(R.id.img_2)).setImageDrawable(new LoadingDrawable(new ColorLineDotLoadingRender(2600L, Color.BLUE)));
		((ImageView) view.findViewById(R.id.img_3)).setImageDrawable(new LoadingDrawable(new ColorLineDotLoadingRender()));
		((ImageView) view.findViewById(R.id.img_4)).setImageDrawable(new LoadingDrawable(new ColorLineDotLoadingRender(3000L, Color.parseColor("#00c300"))));
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.frag_color_line_dot;
	}
}
