package com.breezesoftware.stayfit.core.user

import android.accounts.AccountManager
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.breezesoftware.stayfit.R
import com.breezesoftware.stayfit.core.StayFitApp
import javax.inject.Inject

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 07.04.2018.
 */

/**
 * Класс пользователя
 */
class User {

    @Inject
    lateinit var accountManager : AccountManager

    @Inject
    lateinit var context : Context

    private var sharedPreferences: SharedPreferences

    var email : String? = null

    var name : String = ""

    var age : Int = 70

    var gender : Int = GENDER_MALE

    var weight : Float = 70.0f

    var height : Float = 170.0f

    var experience : Int = EXPERIENCE_NOVICE

    var goal : Int = GOAL_MASS_GAIN

    init {
        StayFitApp.component.inject(this)

        sharedPreferences = context.getSharedPreferences(USER_PREFERENCES_FILE, Context.MODE_PRIVATE)

        getGoogleAccountName()
        loadUser()
    }

    companion object {
        const val USER_PREFERENCES_FILE = "com.breezesoftware.stayfit.user.preferences"

        const val GENDER_MALE = 0
        const val GENDER_FEMALE = 1

        const val EXPERIENCE_NOVICE = 0
        const val EXPERIENCE_ELEMENTARY = 1
        const val EXPERIENCE_PRE_INTERMEDIATE = 2
        const val EXPERIENCE_INTERMEDIATE = 3
        const val EXPERIENCE_PRE_ADVANCED = 4
        const val EXPERIENCE_ADVANCED = 5
        const val EXPERIENCE_PROFESSIONAL = 6

        const val GOAL_MASS_GAIN = 0
        const val GOAL_WEIGHT_LOSS = 1
    }

    /**
     * Получает имя гугл аккаунта, привязанного к устройству,
     * это позволяет идентифицировать пользователя в приложении
     */
    private fun getGoogleAccountName() {
        val accounts = accountManager.getAccountsByType("com.google");

        if (accounts.isEmpty()) {
            Log.e("StayFit", "User device does not contain google accounts")
        }

        /* Берем первый из аккаунтов в качестве
        *  email пользователя */
        email = accounts[0].name
    }

    /**
     * Загружает настройки пользователя из общих настроек приложения
     */
    private fun loadUser() {
        name = sharedPreferences.getString(context.getString(R.string.saved_name), "")
        age = sharedPreferences.getInt(context.getString(R.string.saved_age), 25)
        gender = sharedPreferences.getInt(context.getString(R.string.saved_gender), GENDER_MALE)
        weight = sharedPreferences.getFloat(context.getString(R.string.saved_weight), 70.0f)
        height = sharedPreferences.getFloat(context.getString(R.string.saved_height), 170.0f)
        experience = sharedPreferences.getInt(context.getString(R.string.saved_experience), EXPERIENCE_NOVICE)
        goal = sharedPreferences.getInt(context.getString(R.string.saved_goal), GOAL_MASS_GAIN)
    }

    fun save() {
        val editor = sharedPreferences.edit()

        editor.putString(context.getString(R.string.saved_name),name)
        editor.putInt(context.getString(R.string.saved_age), age)
        editor.putInt(context.getString(R.string.saved_gender), gender)
        editor.putFloat(context.getString(R.string.saved_weight), weight)
        editor.putFloat(context.getString(R.string.saved_height), height)
        editor.putInt(context.getString(R.string.saved_experience), experience)
        editor.putInt(context.getString(R.string.saved_goal), goal)

        editor.apply()
    }
}