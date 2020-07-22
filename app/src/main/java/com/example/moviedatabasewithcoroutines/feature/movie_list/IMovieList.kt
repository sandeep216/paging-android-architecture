package com.example.moviedatabasewithcoroutines.feature.movie_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviedatabasewithcoroutines.base.Resource
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import retrofit2.Response

/**
 * Created by Sandeep on 24/05/20.
 */
interface IMovieList {

    interface ViewModel {
        fun fetchMovieList(page: Int)
        fun getMovieListObserver(): MutableLiveData<Resource<MovieResponseDtos?>>
    }

    interface Repository {
        suspend fun getMovieList(page : Int) : Response<MovieResponseDtos>
    }
}