@file:Suppress("CanBePrimaryConstructorProperty")

package com.breezesoftware.stayfit.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column

/**
 * Представляет таблицу мышечных групп
 */
class MuscleGroup(name: String, description: String) : Model() {

    @Column(name = "name", unique = true)
    var name : String = name;

    @Column(name = "description")
    var description : String = description;
}