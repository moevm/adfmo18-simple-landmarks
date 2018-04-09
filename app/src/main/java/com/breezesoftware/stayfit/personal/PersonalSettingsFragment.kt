package com.breezesoftware.stayfit.personal

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.breezesoftware.stayfit.R
import com.breezesoftware.stayfit.core.StayFitApp
import com.breezesoftware.stayfit.core.user.User
import com.breezesoftware.stayfit.databinding.PersonalSettingsFragmentBinding

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 18.03.2018.
 */

class PersonalSettingsFragment : Fragment() {
    private lateinit var viewModel: PersonalViewModel

    private lateinit var nameEdit : EditText
    private lateinit var maleRadio : RadioButton
    private lateinit var femaleRadio : RadioButton
    private lateinit var genderGroup : RadioGroup
    private lateinit var ageEdit : EditText
    private lateinit var weightEdit : EditText
    private lateinit var heightEdit : EditText
    private lateinit var experienceSpinner : Spinner
    private lateinit var goalSpinner : Spinner


    companion object {
        fun createInstance() : Fragment {
            return PersonalSettingsFragment();
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bindings : PersonalSettingsFragmentBinding = DataBindingUtil
                .inflate(inflater, R.layout.personal_settings_fragment,
                        container, false)

        viewModel = ViewModelProviders.of(activity).get(PersonalViewModel::class.java)

        /* Привязываем объект пользователя к форме */
        bindings.user = viewModel.user

        loadElements(bindings.layout)

        return bindings.layout;
    }

    private fun loadElements(view: View) {
        nameEdit = view.findViewById(R.id.name_edit)
        ageEdit = view.findViewById(R.id.age_edit)

        maleRadio = view.findViewById(R.id.male_rb)
        femaleRadio = view.findViewById(R.id.female_rb)
        genderGroup = view.findViewById(R.id.gender)

        weightEdit = view.findViewById(R.id.weight_edit)
        heightEdit = view.findViewById(R.id.height_edit)

        experienceSpinner = view.findViewById(R.id.experience_spinner)
        goalSpinner = view.findViewById(R.id.goal_spinner)
    }

    /**
     * Введенные данные сохраняются когда активити
     * переходит в состояние паузы
     */
    override fun onPause() {
        val user = viewModel.user

        user.save()

        super.onPause()
    }
}
