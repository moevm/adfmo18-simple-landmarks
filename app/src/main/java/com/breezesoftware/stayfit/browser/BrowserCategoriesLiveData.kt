package com.breezesoftware.stayfit.browser

import android.arch.lifecycle.LiveData
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.breezesoftware.stayfit.core.StayFitApp
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

    private val REQUEST_URL = StayFitApp.config.SERVER_URL + ""

    private var categories = ArrayList<BrowserCategory>()
    private var requestQueue : RequestQueue? = null

    private var context: Context? = null

    @Inject
    constructor(context : Context) : super() {
        this.context = context
        this.requestQueue = Volley.newRequestQueue(this.context)
    }


    override fun onActive() {
        requestCategories()
    }

    private fun requestCategories() {
        val categoriesRequest = StringRequest(Request.Method.GET, REQUEST_URL,
                Response.Listener<String> { response -> onRequestSuccess(response) },
                Response.ErrorListener { error -> onRequestFail(error) })

        requestQueue?.add(categoriesRequest)
    }

    private fun onRequestSuccess(response : String) {
        Log.d("GetCategories", "REQUEST RESULT : " + response)
    }

    private fun onRequestFail(error : VolleyError) {
        Log.e("GetCategories", "Failed to get result: " + error.toString())
    }
}