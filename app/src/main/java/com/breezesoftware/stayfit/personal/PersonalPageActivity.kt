package com.breezesoftware.stayfit.personal

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import com.breezesoftware.stayfit.core.SingleFragmentActivity

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 18.03.2018.
 */

class PersonalPageActivity : SingleFragmentActivity() {

    private lateinit var viewModel: PersonalViewModel

    companion object {
        fun newIntent(from : Context) : Intent {
            return Intent(from, PersonalPageActivity::class.java);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        viewModel = ViewModelProviders.of(this).get(PersonalViewModel::class.java)
    }

    override fun createFragment(): Fragment {
        return PersonalSettingsFragment();
    }
}