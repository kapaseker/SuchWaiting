package azalea.com.suchwating;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import azalea.com.suchwating.sample.ColorLineDotFragment;
import azalea.com.suchwating.sample.IndexFragment;

public class SampleActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

	private DrawerLayout mMenuDrawer = null;
	private ActionBarDrawerToggle mDrawerToggle = null;
	private ViewPager mSampleViewPager = null;
	NavigationView mNavigationView = null;

	private static final Fragment[] SAMPLE_FRAGMENTS = new Fragment[]{
			new IndexFragment(),
			new ColorLineDotFragment(),
	};

	private static final int[] INDEX_IDS = new int[]{
			R.id.nav_index,
			R.id.nav_color_line_dot,
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

		mSampleViewPager = (ViewPager) findViewById(R.id.viewpager);
		mSampleViewPager.setAdapter(new SamplePageAdapter(getSupportFragmentManager(),SAMPLE_FRAGMENTS));
		mSampleViewPager.setCurrentItem(0);
		mNavigationView.setCheckedItem(R.id.nav_index);

		mSampleViewPager.addOnPageChangeListener(this);
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
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.

		switch (item.getItemId()){
			case R.id.nav_index:
				goFragment(0);
				break;
			case R.id.nav_color_line_dot:
				goFragment(1);
				break;
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	private void goFragment(int index) {
		if(mSampleViewPager.getCurrentItem() != index){
			mSampleViewPager.setCurrentItem(index);
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		mNavigationView.setCheckedItem(INDEX_IDS[position]);
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}


	private static class SamplePageAdapter extends FragmentStatePagerAdapter {

		Fragment[] mFragments = null;

		public SamplePageAdapter(FragmentManager fm, Fragment[] frags) {
			super(fm);
			mFragments = frags;
		}

		@Override
		public Fragment getItem(int position) {
			return mFragments[position];
		}

		@Override
		public int getCount() {
			return mFragments.length;
		}
	}
}
