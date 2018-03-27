package com.breezesoftware.stayfit.browser

import android.arch.lifecycle.ViewModel
import com.breezesoftware.stayfit.browser.home.BrowserCategoriesLiveData
import com.breezesoftware.stayfit.core.StayFitApp

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 26.03.2018.
 */

class BrowserViewModel : ViewModel() {

    fun getBrowserCategories() : BrowserCategoriesLiveData {
        return StayFitApp.component.getBrowserCategoriesLiveData()
    }
}