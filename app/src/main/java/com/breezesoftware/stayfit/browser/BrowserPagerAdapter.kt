package com.breezesoftware.stayfit.browser

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.breezesoftware.stayfit.R

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 18.03.2018.
 */

class BrowserPagerAdapter(fm : FragmentManager, private var context : Context) : FragmentPagerAdapter(fm) {

    companion object {
        const val MAIN_CATEGORIES_COUNT = 3;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> BrowserHomeFragment();
            else -> {
                BrowserHomeFragment();
            }
        }
    }

    override fun getCount(): Int {
        return MAIN_CATEGORIES_COUNT;
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position) {
            0 -> context.getString(R.string.home);
            1 -> context.getString(R.string.programs);
            2 -> context.getString(R.string.exercises);
            else -> {
                context.getString(R.string.home);
            }
        }
    }

}