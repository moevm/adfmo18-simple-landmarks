package com.breezesoftware.stayfit.home.graphs

import android.graphics.Color
import com.breezesoftware.stayfit.R
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 14.03.2018.
 */

class ExampleGraphFragment() : GraphFragment() {
    override fun initialize() {
        val data = LineGraphSeries<DataPoint>(arrayOf(
                DataPoint(0.0, 20.0),
                DataPoint(1.0, 10.0),
                DataPoint(2.0, 20.0),
                DataPoint(3.0, 10.5),
                DataPoint(4.0, 20.5),
                DataPoint(5.0, 10.0),
                DataPoint(6.0, 21.5),
                DataPoint(7.0, 10.0)
        ));

        data.color = Color.RED;

        this.graph?.addSeries(data);

        this.graph?.title = activity.getString(R.string.main_graphs_example);
    }
}