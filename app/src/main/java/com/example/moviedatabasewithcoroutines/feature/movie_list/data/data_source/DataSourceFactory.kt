package com.example.moviedatabasewithcoroutines.feature.movie_list.data.data_source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieListItemDto
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Sandeep on 26/07/20.
 */
class DataSourceFactory : DataSource.Factory<Int, MovieListItemDto>() {

    private val movieResponseDataSource = MutableLiveData<MovieItemDataSource>()

    override fun create(): DataSource<Int, MovieListItemDto> {
        val movieItemDataSource = MovieItemDataSource()
        movieResponseDataSource.postValue(movieItemDataSource)
        return movieItemDataSource
    }
}