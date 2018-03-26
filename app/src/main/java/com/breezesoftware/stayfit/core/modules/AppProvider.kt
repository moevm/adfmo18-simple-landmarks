package com.breezesoftware.stayfit.core.modules

import android.content.Context
import com.breezesoftware.stayfit.browser.BrowserCategoriesLiveData
import com.breezesoftware.stayfit.core.AppConfig
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 26.03.2018.
 */

@Module
class AppProvider(private var context: Context) {

    @Provides
    @NotNull
    @Singleton
    fun provideAppContext() : Context {
        return context
    }
}