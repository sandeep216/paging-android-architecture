package com.example.moviedatabasewithcoroutines.feature.movie_list.ui.view_model

import androidx.lifecycle.*
import com.example.moviedatabasewithcoroutines.base.Resource
import com.example.moviedatabasewithcoroutines.feature.movie_list.IMovieList
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.repository.MovieListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Created by Sandeep on 24/05/20.
 */
class MovieListViewModel : ViewModel(), IMovieList.ViewModel {

    private val repository by lazy { MovieListRepository() }
    private val movieListLDObserver by lazy { MutableLiveData<Resource<MovieResponseDtos?>>() }

    override fun fetchMovieList(page : Int) {
        viewModelScope.launch {
            movieListLDObserver.value = Resource.loading()
            movieListLDObserver.value = Resource.success(repository.getMovieList(page).body())
        }
    }

    override fun getMovieListObserver(): MutableLiveData<Resource<MovieResponseDtos?>> {
        return movieListLDObserver
    }
}