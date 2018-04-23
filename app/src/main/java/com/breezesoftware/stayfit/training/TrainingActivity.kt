package com.breezesoftware.stayfit.training

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.breezesoftware.stayfit.core.SingleFragmentActivity
import com.breezesoftware.stayfit.personal.PersonalPageActivity

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 22.04.2018.
 */

class TrainingActivity : SingleFragmentActivity() {

    companion object {
        fun newIntent(from : Context) : Intent {
            return Intent(from, TrainingActivity::class.java);
        }
    }

    override fun createFragment(): Fragment {
        return TrainingFragment();
    }

}