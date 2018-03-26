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

class Muscle(name: String, description: String, latinName: String, category: MuscleGroup)
    : Model() {

    @Column(name = "name", unique = true)
    var name : String = name;

    @Column(name = "latinName", unique = true)
    var latinName : String = latinName;

    @Column(name = "description")
    var description : String = description;

    @Column(name = "category")
    var category : MuscleGroup = category;
}