package com.example.moviedatabasewithcoroutines.feature.movie_list.data.data_source

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.moviedatabasewithcoroutines.base.Resource
import com.example.moviedatabasewithcoroutines.base.RetrofitBuilder
import com.example.moviedatabasewithcoroutines.feature.movie_list.IMovieList
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.api.ApiService
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieListItemDto
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.repository.MovieListRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by Sandeep on 13/07/20.
 */
class MovieItemDataSource() : PageKeyedDataSource<Int, MovieListItemDto>() {
    private val apiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java)
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    companion object {
        const val FIRST_PAGE = 1
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieListItemDto>) {
        scope.launch(Dispatchers.IO + job) {
            val movies = apiService.getMovies(page = FIRST_PAGE)
            if (movies.isSuccessful) {
                callback.onResult(movies.body()!!.results, null, FIRST_PAGE)
            } else {
                Log.e("MovieItemDataSource", "Failed load initial")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieListItemDto>) {
        scope.launch {
            val response = apiService.getMovies(page = params.key + 1)
            if (response.isSuccessful) {
                callback.onResult(response.body()?.results ?: listOf(), FIRST_PAGE + 1)
            } else {
                Log.e("MovieItemDataSource", "Failed load after")
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieListItemDto>) {

    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }

}