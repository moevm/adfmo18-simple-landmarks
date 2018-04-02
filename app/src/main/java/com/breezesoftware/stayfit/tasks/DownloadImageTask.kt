package com.breezesoftware.stayfit.tasks

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.Toast
import com.breezesoftware.stayfit.R
import com.breezesoftware.stayfit.core.StayFitApp
import java.io.FileNotFoundException
import java.lang.ref.WeakReference
import java.net.URL
import javax.inject.Inject

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 03.04.2018.
 */

class DownloadImageTask
    : AsyncTask<String, Void, Drawable> {

    private var imageView : WeakReference<ImageView>
    private lateinit var notFoundImage : Drawable

    companion object {
        val REQUEST_URL = StayFitApp.config.SERVER_URL_STRING + "/get/image/"
    }

    constructor(imageView: ImageView) : super() {
        this.imageView = WeakReference(imageView)
    }

    constructor(imageView: ImageView, notFoundImage: Drawable) : this(imageView) {
        this.notFoundImage = notFoundImage
    }

    override fun doInBackground(vararg files: String): Drawable? {
        for (file in files) {
            try {
                val input = URL(REQUEST_URL + file).openStream()
                return Drawable.createFromStream(input, "fileSrc")
            } catch(e : FileNotFoundException) {
                return notFoundImage
            }
        }

        return null;
    }

    override fun onPostExecute(result: Drawable?) {
        imageView.get()?.setImageDrawable(result)
    }
}