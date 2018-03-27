package com.breezesoftware.stayfit.core.modules

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 27.03.2018.
 */

@Module
class NetworkProvider {
    @Provides
    @NotNull
    @Singleton
    fun provideRequestQueue(applicationContext: Context) : RequestQueue {
        return Volley.newRequestQueue(applicationContext)
    }
}