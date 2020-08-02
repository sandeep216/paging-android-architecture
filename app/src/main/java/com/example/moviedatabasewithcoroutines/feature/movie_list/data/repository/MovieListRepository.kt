package com.example.moviedatabasewithcoroutines.feature.movie_list.data.repository

import android.util.Log
import com.example.moviedatabasewithcoroutines.base.RetrofitBuilder
import com.example.moviedatabasewithcoroutines.feature.movie_list.IMovieList
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.api.ApiService
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * Created by Sandeep on 24/05/20.
 */
class MovieListRepository : IMovieList.Repository {

    override suspend fun getMovieList(page: Int): Response<MovieResponseDtos> {
        val apiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java)
        try {
            val movies = apiService.getMovies(page = page)
            Log.d("MovieList", movies.toString())

        } catch (e: Exception) {

        }
        return Response.error(1001, null)
    }
}