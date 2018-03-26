package com.breezesoftware.stayfit.core

import com.breezesoftware.stayfit.browser.BrowserActivity
import com.breezesoftware.stayfit.browser.BrowserCategoriesLiveData
import com.breezesoftware.stayfit.core.modules.AppProvider
import dagger.Component
import javax.inject.Singleton

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 26.03.2018.
 */

@Component(modules = [(AppProvider::class)])
@Singleton
interface StayFitComponent {
    fun inject(activity: BrowserActivity)
    fun inject(liveData: BrowserCategoriesLiveData)

    @Singleton
    fun getBrowserCategoriesLiveData() : BrowserCategoriesLiveData
}