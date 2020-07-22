package com.example.moviedatabasewithcoroutines.feature.movie_list.data.api

import com.example.moviedatabasewithcoroutines.base.Constants
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sandeep on 23/05/20.
 */
interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(@Query("language") language: String = "en", @Query("api_key") apiKey : String = Constants.API_KEY, @Query("page") page : Int) : Response<MovieResponseDtos>
}