package com.breezesoftware.stayfit.core

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.breezesoftware.stayfit.R

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 18.03.2018.
 */

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract fun createFragment() : Fragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_activity);

        val fm = supportFragmentManager;
        var fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}