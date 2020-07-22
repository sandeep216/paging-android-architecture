package com.example.moviedatabasewithcoroutines.base

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Sandeep on 24/05/20.
 */

fun ImageView.load(context : Context, url : String) {
    Glide.with(context)
        .load(url)
        .into(this)
}