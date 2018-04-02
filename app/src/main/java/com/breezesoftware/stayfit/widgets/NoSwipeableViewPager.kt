package com.breezesoftware.stayfit.widgets

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 02.04.2018.
 */

class NoSwipeableViewPager : ViewPager {

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false;
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false;
    }
}