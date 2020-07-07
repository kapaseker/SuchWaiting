package azalea.com.suchwating;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import azalea.com.suchwating.sample.ColorLineDotFragment;
import azalea.com.suchwating.sample.IndexFragment;
import azalea.com.suchwating.sample.TriangleFragment;
import azalea.com.suchwating.sample.TriangleShrinkDotFragment;

public class SampleActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	private DrawerLayout mMenuDrawer = null;
	private ActionBarDrawerToggle mDrawerToggle = null;
	NavigationView mNavigationView = null;

	private static final Fragment[] SAMPLE_FRAGMENTS = new Fragment[]{
			new IndexFragment(),
			new ColorLineDotFragment(),
			new TriangleFragment(),
			new TriangleShrinkDotFragment(),
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mMenuDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(
				this, mMenuDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		mMenuDrawer.addDrawerListener(mDrawerToggle);
		mDrawerToggle.syncState();

		mNavigationView = (NavigationView) findViewById(R.id.nav_view);
		mNavigationView.setNavigationItemSelectedListener(this);

		if (getSupportFragmentManager().findFragmentById(R.id.fragment) == null) {
			goFragment(0);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mMenuDrawer.removeDrawerListener(mDrawerToggle);
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sample, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {

		switch (item.getItemId()) {
			case R.id.nav_color_line_dot:
				goFragment(1);
				break;
			case R.id.navi_triangle:
				goFragment(2);
				break;
			case R.id.navi_triangleshrink:
				goFragment(3);
				break;
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	private void goFragment(int index) {
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment, SAMPLE_FRAGMENTS[index]).commit();
	}
}
