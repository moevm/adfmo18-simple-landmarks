package com.breezesoftware.stayfit.browser

import org.json.JSONObject

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 27.03.2018.
 */

class BrowserItem(
        var name : String,
        var description : String,
        var price : Int,
        var image : String,
        var rating : Int
) {

    companion object {
        fun fromJSON(json : JSONObject) : BrowserItem {
            val name = json.getString("Name")
            val description = json.getString("Description")
            val price = json.getInt("Price")
            val image = json.getString("Image")
            val rating = json.getInt("Rating")

            return BrowserItem(name, description, price, image, rating)
        }
    }

}