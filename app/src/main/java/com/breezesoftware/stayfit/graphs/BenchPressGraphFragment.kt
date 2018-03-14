package com.breezesoftware.stayfit.graphs

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

class BenchPressGraphFragment() : GraphFragment() {
    override fun initialize() {
        val data = LineGraphSeries<DataPoint>(arrayOf(
                DataPoint(0.0, 20.0),
                DataPoint(1.0, 30.0),
                DataPoint(2.0, 30.0),
                DataPoint(3.0, 32.5),
                DataPoint(4.0, 37.5),
                DataPoint(5.0, 40.0),
                DataPoint(6.0, 41.5),
                DataPoint(7.0, 40.0)
        ));

        data.color = Color.GREEN;

        this.graph?.addSeries(data);

        this.graph?.title = activity.getString(R.string.main_graphs_bench_press);
    }
}