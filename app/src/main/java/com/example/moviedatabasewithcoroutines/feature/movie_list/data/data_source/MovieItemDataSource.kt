package com.example.moviedatabasewithcoroutines.feature.movie_list.data.data_source

import androidx.paging.PageKeyedDataSource
import com.example.moviedatabasewithcoroutines.feature.movie_list.IMovieList
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieListItemDto
import com.example.moviedatabasewithcoroutines.feature.movie_list.ui.view_model.MovieListViewModel

/**
 * Created by Sandeep on 13/07/20.
 */
class MovieItemDataSource(var viewModel: IMovieList.ViewModel) : PageKeyedDataSource<Int, MovieListItemDto>() {

    companion object {
       const val FIRST_PAGE = 1
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieListItemDto>) {
        viewModel.fetchMovieList(FIRST_PAGE)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieListItemDto>) {
        viewModel.fetchMovieList(params.key)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieListItemDto>) {

    }

}