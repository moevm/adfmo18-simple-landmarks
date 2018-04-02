package com.breezesoftware.stayfit.browser.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.breezesoftware.stayfit.R
import com.breezesoftware.stayfit.browser.BrowserViewModel

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 18.03.2018.
 */

class BrowserHomeFragment : Fragment() {

    private lateinit var viewModel : BrowserViewModel
    private lateinit var categoriesRecycler : RecyclerView
    private lateinit var categoriesRecyclerAdapter : BrowserRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(activity).get(BrowserViewModel::class.java)
        viewModel.getBrowserCategories().observe(activity,
                Observer { categories : List<BrowserCategory>? -> updateCategories(categories)} )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        categoriesRecycler = view.findViewById(R.id.categoriesRecycler)
        setCategoriesRecycler()
    }

    private fun setCategoriesRecycler() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        categoriesRecycler.layoutManager = layoutManager
        //categoriesRecycler.setHasFixedSize(true)
    }

    private fun updateCategories(categories : List<BrowserCategory>?) {
        if (categories == null) {
            return;
        }

        this.categoriesRecyclerAdapter = BrowserRecyclerAdapter(
                activity.supportFragmentManager, categories)
        categoriesRecycler.adapter = this.categoriesRecyclerAdapter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.browser_home, container, false);
        return view;
    }
}
