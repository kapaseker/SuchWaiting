package azalea.com.suchwating;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import azalea.com.suchwating.sample.ColorLineDotFragment;
import azalea.com.suchwating.sample.IndexFragment;

public class SampleActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	private DrawerLayout mMenuDrawer = null;
	private ActionBarDrawerToggle mDrawerToggle = null;
	NavigationView mNavigationView = null;

	private static final Fragment[] SAMPLE_FRAGMENTS = new Fragment[]{
			new IndexFragment(),
			new ColorLineDotFragment(),
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

        if(getSupportFragmentManager().findFragmentById(R.id.fragment) == null){
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
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.

		switch (item.getItemId()){
			case R.id.nav_color_line_dot:
				goFragment(1);
				break;
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	private void goFragment(int index) {
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment,SAMPLE_FRAGMENTS[index]).commit();
	}
}
