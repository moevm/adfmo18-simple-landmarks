package com.breezesoftware.stayfit.graphs

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.breezesoftware.stayfit.R
import com.jjoe64.graphview.GraphView

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 14.03.2018.
 */
@SuppressLint("ValidFragment")
abstract class GraphFragment() : Fragment() {

    protected var graph : GraphView? = null;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.graph_fragment, container, false);

        return rootView;
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        this.graph = view?.findViewById(R.id.graph);

        /* Включаем горизонтальный скроллинг */
        this.graph?.viewport?.isScrollable = true;

        initialize();
    }

    /* Наследники должны определить данный метод
    *  и инициализировать графики актульными значениями */
    abstract fun initialize();
}