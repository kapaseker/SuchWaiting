package azalea.com.suchwating.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender;
import com.azalea.suchwaiting.wrapper_drawable.LoadingDrawable;

import androidx.annotation.Nullable;
import azalea.com.suchwating.BaseFragment;
import azalea.com.suchwating.R;


/**
 * base five loading render sample
 */
public abstract class FiveLoadRenderFragment extends BaseFragment {
	@Override
	protected int getLayoutResource() {
		return R.layout.frag_color_line_dot;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		((ImageView) view.findViewById(R.id.img_1)).setImageDrawable(new LoadingDrawable(getFiveLoadingRender()[0]));
        ((ImageView) view.findViewById(R.id.img_2)).setImageDrawable(new LoadingDrawable(getFiveLoadingRender()[1]));
        ((ImageView) view.findViewById(R.id.img_3)).setImageDrawable(new LoadingDrawable(getFiveLoadingRender()[2]));
        ((ImageView) view.findViewById(R.id.img_4)).setImageDrawable(new LoadingDrawable(getFiveLoadingRender()[3]));
        ((ImageView) view.findViewById(R.id.img_5)).setImageDrawable(new LoadingDrawable(getFiveLoadingRender()[4]));
	}

	/**
	 * you must implements this to give me five loading render, it will show im imageView
	 */
	protected abstract BaseLoadingRender[] getFiveLoadingRender();
}
