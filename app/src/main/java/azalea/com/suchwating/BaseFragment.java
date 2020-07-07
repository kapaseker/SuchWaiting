package azalea.com.suchwating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * base fragment for sample show
 */
public abstract class BaseFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(getLayoutResource(), null);
	}

	protected abstract int getLayoutResource();
}
