package azalea.com.suchwating.sample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import azalea.com.suchwating.BaseFragment
import azalea.com.suchwating.R
import com.azalea.suchwaiting.loadingimplemention.BaseLoadingRender
import com.azalea.suchwaiting.wrapper_drawable.LoadingDrawable

/**
 * base five loading render sample
 */
abstract class FiveLoadRenderFragment : BaseFragment() {
    override val layoutResource: Int
        protected get() = R.layout.frag_color_line_dot

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view.findViewById<View>(R.id.img_1) as ImageView).setImageDrawable(LoadingDrawable(fiveLoadingRender[0]))
        (view.findViewById<View>(R.id.img_2) as ImageView).setImageDrawable(LoadingDrawable(fiveLoadingRender[1]))
        (view.findViewById<View>(R.id.img_3) as ImageView).setImageDrawable(LoadingDrawable(fiveLoadingRender[2]))
        (view.findViewById<View>(R.id.img_4) as ImageView).setImageDrawable(LoadingDrawable(fiveLoadingRender[3]))
        (view.findViewById<View>(R.id.img_5) as ImageView).setImageDrawable(LoadingDrawable(fiveLoadingRender[4]))
    }

    /**
     * you must implements this to give me five loading render, it will show im imageView
     */
    protected abstract val fiveLoadingRender: Array<BaseLoadingRender>
}