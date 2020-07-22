package com.example.moviedatabasewithcoroutines.feature.movie_list.data.repository

import com.example.moviedatabasewithcoroutines.base.RetrofitBuilder
import com.example.moviedatabasewithcoroutines.feature.movie_list.IMovieList
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.api.ApiService
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import retrofit2.Response

/**
 * Created by Sandeep on 24/05/20.
 */
class MovieListRepository : IMovieList.Repository {

    override suspend fun getMovieList(page : Int) : Response<MovieResponseDtos> {
        val apiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java)
        return apiService.getMovies(page = page)
    }
}