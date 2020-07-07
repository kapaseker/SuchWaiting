package azalea.com.suchwating

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import azalea.com.suchwating.sample.*
import com.google.android.material.navigation.NavigationView

class SampleActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var mMenuDrawer: DrawerLayout? = null
    private var mDrawerToggle: ActionBarDrawerToggle? = null
    var mNavigationView: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        mMenuDrawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        mDrawerToggle = ActionBarDrawerToggle(
                this, mMenuDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mMenuDrawer!!.addDrawerListener(mDrawerToggle!!)
        mDrawerToggle!!.syncState()
        mNavigationView = findViewById<View>(R.id.nav_view) as NavigationView
        mNavigationView!!.setNavigationItemSelectedListener(this)
        if (supportFragmentManager.findFragmentById(R.id.fragment) == null) {
            goFragment(0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mMenuDrawer!!.removeDrawerListener(mDrawerToggle!!)
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.sample, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_color_line_dot -> goFragment(1)
            R.id.navi_triangle -> goFragment(2)
            R.id.navi_triangleshrink -> goFragment(3)
            R.id.navi_loadingbar -> goFragment(4)
        }
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun goFragment(index: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment, SAMPLE_FRAGMENTS[index]).commit()
    }

    companion object {
        private val SAMPLE_FRAGMENTS = arrayOf<Fragment>(
                IndexFragment(),
                ColorLineDotFragment(),
                TriangleFragment(),
                TriangleShrinkDotFragment(),
                LoadingBarFragment()
        )
    }
}