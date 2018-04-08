package com.breezesoftware.stayfit.core.modules

import android.accounts.AccountManager
import android.content.Context
import android.content.SharedPreferences
import com.breezesoftware.stayfit.core.user.User
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

    @Provides
    @NotNull
    @Singleton
    fun provideUser() : User {
        return User();
    }

    @Provides
    @NotNull
    @Singleton
    fun provideAccountManager() : AccountManager {
        return AccountManager.get(context);
    }
}