package com.example.moviedatabasewithcoroutines

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Sandeep on 16/08/20.
 */
@HiltAndroidApp
class MovieApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}