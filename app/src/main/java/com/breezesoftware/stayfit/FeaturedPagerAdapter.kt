package com.breezesoftware.stayfit

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.tobishiba.circularviewpager.library.BaseCircularViewPagerAdapter


/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 14.03.2018.
 */

class FeaturedPagerAdapter(private var context: Context, fm: FragmentManager, features: List<Int>)
    : BaseCircularViewPagerAdapter<Int>(fm, features) {

    override fun getFragmentForItem(item: Int): Fragment {
        return FeaturedItemFragment.newInstance(context, item);
    }
}