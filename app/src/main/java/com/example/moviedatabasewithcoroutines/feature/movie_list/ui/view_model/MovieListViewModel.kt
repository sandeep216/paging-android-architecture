package com.example.moviedatabasewithcoroutines.feature.movie_list.ui.view_model

import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviedatabasewithcoroutines.base.Resource
import com.example.moviedatabasewithcoroutines.feature.movie_list.IMovieList
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.data_source.DataSourceFactory
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.data_source.MovieItemDataSource
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieListItemDto
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieResponseDtos
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.repository.MovieListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Created by Sandeep on 24/05/20.
 */
class MovieListViewModel : ViewModel(), IMovieList.ViewModel {

   // private val movieListLDObserver by lazy { MutableLiveData<Resource<MovieResponseDtos?>>() }
   private var userPagedList: LiveData<PagedList<MovieListItemDto>>

    init {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()

        userPagedList = LivePagedListBuilder(DataSourceFactory(),config).build()
    }

    private fun initializedPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<Int, MovieListItemDto> {

        val dataSourceFactory = object : DataSource.Factory<Int, MovieListItemDto>() {
            override fun create(): DataSource<Int, MovieListItemDto> {
                return MovieItemDataSource()
            }
        }
        return LivePagedListBuilder<Int, MovieListItemDto>(dataSourceFactory, config)
    }

    override fun getMovieListObserver(): LiveData<PagedList<MovieListItemDto>> {
        return userPagedList
    }
}