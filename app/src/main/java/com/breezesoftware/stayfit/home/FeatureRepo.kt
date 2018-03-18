package com.breezesoftware.stayfit.home

import com.breezesoftware.stayfit.R

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 14.03.2018.
 */

class FeatureRepo {

    companion object {
        val images = arrayOf(
                R.drawable.featured01,
                R.drawable.featured02,
                R.drawable.featured03,
                R.drawable.featured04
        );

        fun getFeatureImages() : List<Int> {
            return images.toList();
        }
    }
}