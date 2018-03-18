package com.breezesoftware.stayfit.browser

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.breezesoftware.stayfit.R

/**
 * Активити просмотра новых программ тренировок, диет, упражнений и так
 * далее.
 */
class BrowserActivity : AppCompatActivity() {

    private var mainTabLayout : TabLayout? = null;
    private var mainViewPager : ViewPager? = null;

    companion object {
        fun newIntent(from : Context) : Intent {
            return Intent(from, BrowserActivity::class.java);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.browser);

        setUpViewPager();
    }

    private fun setUpViewPager() {
        mainTabLayout = findViewById(R.id.main_tabs);
        mainViewPager = findViewById(R.id.main_vp);

        mainViewPager?.adapter = BrowserPagerAdapter(supportFragmentManager, this);

        mainTabLayout?.setupWithViewPager(mainViewPager);
    }
}
