package com.breezesoftware.stayfit.graphs

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
 * Created by popof on 14.03.2018.
 */

class GraphsPagerAdapter(fm: FragmentManager, private var context: Context)
    : FragmentPagerAdapter(fm) {

    /* Константы */
    companion object {
        const val TAB_COUNT = 3;
    }

    /* Возвращает конкретную вкладку (фрагмент) */
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MassGraphFragment();
            1 -> BenchPressGraphFragment();
            2 -> ExampleGraphFragment();
            else -> {
                MassGraphFragment();
            }
        }
    }

    /* Кол-во вкладок */
    override fun getCount(): Int {
        return TAB_COUNT;
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.getString(R.string.main_graphs_mass);
            1 -> context.getString(R.string.main_graphs_bench_press);
            2 -> context.getString(R.string.main_graphs_example);
            else -> {
                context.getString(R.string.undefined)
            }
        }
    }

}