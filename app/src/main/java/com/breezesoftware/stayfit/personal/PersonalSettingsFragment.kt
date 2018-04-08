package com.breezesoftware.stayfit.personal

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.breezesoftware.stayfit.R
import com.breezesoftware.stayfit.core.user.User

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
        val view = inflater.inflate(R.layout.personal_settings_fragment,
                container, false);

        viewModel = ViewModelProviders.of(this).get(PersonalViewModel::class.java)

        loadElements(view)
        updateElements()

        return view;
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

    private fun updateElements() {
        val user = viewModel.user

        nameEdit.setText(user.name)
        ageEdit.setText(user.age.toString())

        when (user.gender) {
            User.GENDER_MALE -> genderGroup.check(R.id.male_rb)
            User.GENDER_FEMALE -> genderGroup.check(R.id.female_rb)
        }

        weightEdit.setText(user.weight.toString())
        heightEdit.setText(user.height.toString())

        experienceSpinner.setSelection(user.experience)
        goalSpinner.setSelection(user.goal)
    }

    private fun setHandlers() {
    }

    /**
     * Введенные данные сохраняются когда активити
     * переходит в состояние паузы
     *
     * TODO: use android data binding library
     */
    override fun onPause() {
        val user = viewModel.user

        user.name = nameEdit.text.toString()
        user.age = ageEdit.text.toString().toInt()
        user.weight = weightEdit.text.toString().toFloat()
        user.height = heightEdit.text.toString().toFloat()

        user.gender = when (genderGroup.checkedRadioButtonId) {
            R.id.male_rb -> User.GENDER_MALE
            R.id.female_rb -> User.GENDER_FEMALE
            else -> User.GENDER_MALE
        }

        user.experience = experienceSpinner.selectedItemPosition
        user.goal = goalSpinner.selectedItemPosition

        user.save()

        super.onPause()
    }
}
