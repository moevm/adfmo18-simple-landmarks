package com.breezesoftware.stayfit.browser.home

import com.breezesoftware.stayfit.browser.BrowserItem
import org.json.JSONArray
import org.json.JSONObject

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 26.03.2018.
 */

class BrowserCategory(
        var name : String,
        var description : String,
        var itemType : String,
        var items : List<BrowserItem>,
        var image : String = ""
) {

    companion object {
        fun fromJSON(json : JSONObject) : BrowserCategory {
            val name = json.getString("Name")
            val description = json.getString("Description")
            val itemType = json.getString("ItemType")

            val items = if (!json.isNull("Items")) {
                itemsFromJSON(json.getJSONArray("Items"))
            } else {
                ArrayList<BrowserItem>()
            }

            return BrowserCategory(name, description, itemType, items)
        }

        private fun itemsFromJSON(jsonArray : JSONArray) : List<BrowserItem> {
            val list = ArrayList<BrowserItem>();

            (0 until jsonArray.length()).mapTo(list) {
                BrowserItem.fromJSON(jsonArray.getJSONObject(it))
            }

            return list
        }
    }

}