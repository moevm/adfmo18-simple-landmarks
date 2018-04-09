package com.breezesoftware.stayfit.home

import android.arch.lifecycle.ViewModel
import com.breezesoftware.stayfit.core.StayFitApp
import com.breezesoftware.stayfit.core.user.User
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    @Inject
    lateinit var user: User

    init {
        StayFitApp.component.inject(this)
    }
}