package com.breezesoftware.stayfit.widgets

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.breezesoftware.stayfit.R

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 14.03.2018.
 */

class FeaturedItemFragment() : Fragment() {

    private var drawableId: Int = R.drawable.featured01;

    companion object {
        fun newInstance(context: Context, drawableId: Int): FeaturedItemFragment {
            val item = FeaturedItemFragment();
            item.drawableId = drawableId;

            return item;
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater?.inflate(R.layout.image_item, container, false);

        val imageView = layout?.findViewById<ImageView>(R.id.imageView);
        imageView?.setImageResource(drawableId);

        return layout;
    }
}