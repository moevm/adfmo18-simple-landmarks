@file:Suppress("CanBePrimaryConstructorProperty")

package com.breezesoftware.stayfit.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 19.03.2018.
 */

class Exercise(name: String, description: String, difficulty: Int, category: MuscleGroup,
               isBase: Boolean = false) : Model() {

    @Column(name = "name", unique = true)
    var name : String = name;

    @Column(name = "description")
    var description : String = description;

    @Column(name = "difficulty")
    var difficulty : Int = difficulty;

    // Мышечная группа, тренируемая данным упражнением
    @Column(name = "category")
    var category : MuscleGroup = category;

    // Является ли базовым упражнением (задействует два или более сустава)
    @Column(name = "isBase")
    var isBase : Boolean = isBase;
}