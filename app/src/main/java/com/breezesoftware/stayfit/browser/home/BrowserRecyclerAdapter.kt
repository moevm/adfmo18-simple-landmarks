package com.breezesoftware.stayfit.browser.home

import android.app.ActionBar
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.breezesoftware.stayfit.R
import com.breezesoftware.stayfit.browser.BrowserItem
import com.breezesoftware.stayfit.core.StayFitApp
import com.breezesoftware.stayfit.tasks.DownloadImageTask
import javax.inject.Inject

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 27.03.2018.
 */

class BrowserRecyclerAdapter(private var fm : FragmentManager, private var categories : List<BrowserCategory>)
    : RecyclerView.Adapter<BrowserRecyclerAdapter.CategoryHolder>() {

    companion object {
        val TAG = "StayFit"
    }

    class CategoryHolder(var categoryCard : CardView)
        : RecyclerView.ViewHolder(categoryCard) {

        @Inject
        lateinit var context : Context

        private val difficultyStrings = hashMapOf<Int, Int>(
                1 to R.string.difficulty_very_easy,
                2 to R.string.difficulty_easy,
                3 to R.string.difficulty_normal,
                4 to R.string.difficulty_hard,
                5 to R.string.difficulty_very_hard
        )

        init {
            StayFitApp.component.inject(this)
        }

        fun populateLayout(items : List<BrowserItem>) {
            val layout = this.categoryCard.findViewById<LinearLayout>(R.id.itemContainer)
            val inflater = LayoutInflater.from(context)

            items.map {
                val itemView = inflater.inflate(R.layout.browser_category_item, layout, false)

                val layoutParams = itemView.layoutParams as LinearLayout.LayoutParams
                layoutParams.setMargins(0, 0, 10, 0)
                itemView.layoutParams = layoutParams

                setCategoryItem(itemView, it)

                layout.addView(itemView)
            }

            val lastChild = layout.getChildAt(layout.childCount - 1)
            val layoutParams = lastChild.layoutParams as LinearLayout.LayoutParams
            layoutParams.setMargins(0, 0, 0, 0)
            lastChild.layoutParams = layoutParams
        }

        private fun setCategoryItem(browserItemView : View, item : BrowserItem) {
            val imageView = browserItemView.findViewById<ImageView>(R.id.itemImage)
            val nameTV = browserItemView.findViewById<TextView>(R.id.itemName)
            //val descriptionTV = browserItemView.findViewById<TextView>(R.id.itemDescription)
            val difficultyTV = browserItemView.findViewById<TextView>(R.id.itemDifficulty)
            val priceTV = browserItemView.findViewById<TextView>(R.id.itemPrice)
            val ratingBar = browserItemView.findViewById<RatingBar>(R.id.itemRating)

            nameTV?.text = item.name
            //descriptionTV?.text = item.description

            imageView.contentDescription = item.description

            // Асинхронно закачиваем изображение
            DownloadImageTask(imageView,
                    ContextCompat.getDrawable(context, R.drawable.image_not_found))
                    .execute(item.image)

            if (item.price != 0) {
                priceTV?.text = item.price.toString()
            } else {
                priceTV?.text = context.getString(R.string.free)
            }

            difficultyTV?.text = context.getString(difficultyStrings[item.difficulty] ?: R.string.difficulty_normal)

            // TODO: Сделать рейтинг действительным числом
            //ratingBar?.rating = item.rating + 2.3f
        }
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
        val categoryName = holder?.categoryCard?.findViewById<TextView>(R.id.categoryName)
        val categoryDescription = holder?.categoryCard?.findViewById<TextView>(R.id.categoryDescription)

        categoryName?.text = categories[position].name
        categoryDescription?.text = categories[position].description

        holder?.populateLayout(categories[position].items);
    }
}