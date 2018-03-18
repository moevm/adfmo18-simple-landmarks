package com.breezesoftware.stayfit.about

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.breezesoftware.stayfit.core.SingleFragmentActivity

class AboutActivity : SingleFragmentActivity() {

    companion object {
        fun newIntent(from : Context) : Intent {
            return Intent(from, AboutActivity::class.java);
        }
    }

    override fun createFragment(): Fragment {
        return AboutFragment();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
