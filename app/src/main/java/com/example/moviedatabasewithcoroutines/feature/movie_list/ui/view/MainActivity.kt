package com.example.moviedatabasewithcoroutines.feature.movie_list.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabasewithcoroutines.R
import com.example.moviedatabasewithcoroutines.base.Resource
import com.example.moviedatabasewithcoroutines.base.Status
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import com.example.moviedatabasewithcoroutines.feature.movie_list.ui.view.adapter.MovieAdapter
import com.example.moviedatabasewithcoroutines.feature.movie_list.ui.view_model.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mViewModel by lazy { ViewModelProviders.of(this)[MovieListViewModel::class.java] }
    private val TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        initToolbar()
        initRecyclerView()
        initObserver()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbarMovieList)
        supportActionBar?.title = "Movie List"
    }

    private fun initObserver() {
        mViewModel.getMovieListObserver().observe(this, Observer {
            handleResponse(it)
        })
    }

    private fun handleResponse(it: Resource<out MovieResponseDtos?>?) {
        when(it!!.status) {
            Status.SUCCESS ->  Log.i(TAG, "" + it.data!!.results.size)
        }
    }

    private fun initRecyclerView() {
        rvMovies.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = MovieAdapter()
        }
    }
}
