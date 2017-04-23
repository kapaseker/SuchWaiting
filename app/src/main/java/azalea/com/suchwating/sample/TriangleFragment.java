package azalea.com.suchwating.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.azalea.suchwaiting.loadingimplemention.triangle.TriangleDotRender;
import com.azalea.suchwaiting.wrapper_drawable.LoadingDrawable;

import azalea.com.suchwating.BaseFragment;
import azalea.com.suchwating.R;

/**
 * Created by Panoo on 2017/4/23.
 */

public class TriangleFragment extends BaseFragment {
	@Override
	protected int getLayoutResource() {
		return R.layout.frag_color_line_dot;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		((ImageView) view.findViewById(R.id.img_1)).setImageDrawable(new LoadingDrawable(new TriangleDotRender()));
	}
}
