package com.breezesoftware.stayfit.personal

import android.arch.lifecycle.ViewModel
import com.breezesoftware.stayfit.core.StayFitApp
import com.breezesoftware.stayfit.core.user.User
import javax.inject.Inject

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 07.04.2018.
 */

class PersonalViewModel : ViewModel() {

    @Inject
    lateinit var user: User

    init {
        StayFitApp.component.inject(this)
    }
}