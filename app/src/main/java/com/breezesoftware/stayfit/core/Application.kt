package com.breezesoftware.stayfit.core

import android.app.Application
import com.breezesoftware.stayfit.core.modules.AppProvider

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 26.03.2018.
 */

class StayFitApp : Application() {
    companion object {
        lateinit var component : StayFitComponent
        val config = AppConfig()
    }

    override fun onCreate() {
        super.onCreate()

        buildComponent()
    }

    private fun buildComponent() {
        component = DaggerStayFitComponent.builder()
                .appProvider(AppProvider(this)).build()
    }
}