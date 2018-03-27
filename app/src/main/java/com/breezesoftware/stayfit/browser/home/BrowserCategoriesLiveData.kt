package com.breezesoftware.stayfit.browser.home

import android.arch.lifecycle.LiveData
import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.breezesoftware.stayfit.core.StayFitApp
import org.json.JSONArray
import javax.inject.Inject

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 26.03.2018.
 */

class BrowserCategoriesLiveData
    : LiveData<List<BrowserCategory>> {

    private val REQUEST_URL = StayFitApp.config.SERVER_URL + "/get/browserCategories?from=0&to=5"

    private var categories = ArrayList<BrowserCategory>()

    private var requestQueue : RequestQueue? = null
    private var context: Context? = null

    @Inject
    constructor(context : Context, requestQueue: RequestQueue) : super() {
        this.context = context
        this.requestQueue = requestQueue
    }


    override fun onActive() {
        if (categories.isEmpty()) {
            requestCategories()
        }
    }

    private fun requestCategories() {
        val categoriesRequest = JsonArrayRequest(REQUEST_URL,
                Response.Listener<JSONArray> { json -> onRequestSuccess(json) },
                Response.ErrorListener { error -> onRequestFail(error) })

        requestQueue?.add(categoriesRequest)
    }

    private fun onRequestSuccess(jsonCategories : JSONArray) {
        // TODO: multithreading
        (0 until jsonCategories.length())
                .map { BrowserCategory.fromJSON(jsonCategories.getJSONObject(it)) }
                //.filter { it.items.isNotEmpty() }
                .forEach {
                    categories.add(it)
                }

        this.value = categories
    }

    private fun onRequestFail(error : VolleyError) {
        Log.e("StayFit", "Failed to get result: " + error.toString())
    }

}