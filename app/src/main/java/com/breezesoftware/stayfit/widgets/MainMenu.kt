package com.breezesoftware.stayfit.widgets

import android.content.Context
import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import com.breezesoftware.stayfit.PersonalPageActivity
import com.breezesoftware.stayfit.R

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 18.03.2018.
 */

class MainMenu(private var drawerLayout : DrawerLayout, private var context : Context)
    : NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true;
        drawerLayout.closeDrawers();

        when(item.itemId) {
            R.id.menu_personal_settings -> onPersonalSettings();
            R.id.menu_program_browser -> onProgramBrowser();
            R.id.menu_excercise_browser -> onExerciseBrowser();
            R.id.menu_settings -> onSettings();
            R.id.menu_about -> onAbout();
            R.id.menu_exit -> onExit();
            else -> {
                return true;
            }
        }

        return true;
    }

    private fun onExit() {
    }

    private fun onAbout() {
    }

    private fun onSettings() {
    }

    private fun onProgramBrowser() {
    }

    private fun onExerciseBrowser() {
    }

    private fun onPersonalSettings() {
        val personalSettings = PersonalPageActivity.newIntent(context);
        context.startActivity(personalSettings);
    }
}