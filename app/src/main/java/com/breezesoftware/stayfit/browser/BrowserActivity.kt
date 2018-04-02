package com.breezesoftware.stayfit.browser

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.breezesoftware.stayfit.R
import com.breezesoftware.stayfit.widgets.NoSwipeableViewPager

/**
 * Активити просмотра новых программ тренировок, диет, упражнений и так
 * далее.
 */
class BrowserActivity : AppCompatActivity() {

    private var mainTabLayout : TabLayout? = null
    private lateinit var mainViewPager : NoSwipeableViewPager

    private lateinit var viewModel : BrowserViewModel

    companion object {
        fun newIntent(from : Context) : Intent {
            return Intent(from, BrowserActivity::class.java);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.browser);

        setUpViewPager();

        viewModel = ViewModelProviders.of(this).get(BrowserViewModel::class.java)
    }

    private fun setUpViewPager() {
        mainTabLayout = findViewById(R.id.main_tabs);
        mainViewPager = findViewById(R.id.main_vp);

        mainViewPager.adapter = BrowserPagerAdapter(supportFragmentManager, this);

        mainTabLayout?.setupWithViewPager(mainViewPager);
    }
}
