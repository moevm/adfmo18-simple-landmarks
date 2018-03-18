package com.breezesoftware.stayfit.home.graphs

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
class MassGraphFragment : GraphFragment() {
    override fun initialize() {
        val data = LineGraphSeries<DataPoint>(arrayOf(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 3.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 4.0),
                DataPoint(4.0, 5.0),
                DataPoint(5.0, 7.0)
        ));

        this.graph?.addSeries(data);

        this.graph?.title = activity.getString(R.string.main_graphs_mass);
    }
}