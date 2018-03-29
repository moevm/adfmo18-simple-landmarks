package com.breezesoftware.stayfit.browser.home

import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.breezesoftware.stayfit.R

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 27.03.2018.
 */

class BrowserRecyclerAdapter(private var fm : FragmentManager, var categories : List<BrowserCategory>)
    : RecyclerView.Adapter<BrowserRecyclerAdapter.CategoryHolder>() {

    companion object {
        val TAG = "StayFit"
    }

    class CategoryHolder(var categoryCard : CardView)
        : RecyclerView.ViewHolder(categoryCard) {


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryHolder {
        val categoryCardView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.browser_category_card, parent, false) as CardView

        return CategoryHolder(categoryCardView)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryHolder?, position: Int) {
        val pager = holder?.categoryCard?.findViewById<ViewPager>(R.id.viewPager)
        val categoryName = holder?.categoryCard?.findViewById<TextView>(R.id.categoryName)

        categoryName?.text = categories[position].name
        pager?.adapter = BrowserCategoryPagerAdapter(categories[position].items,
                categories[position].itemType)

        Log.d(TAG, String.format("Bind view holder on position %d. Category = %s",
                position, categoryName?.text));
    }
}