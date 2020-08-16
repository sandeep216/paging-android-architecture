package com.example.moviedatabasewithcoroutines.feature.movie_list.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedatabasewithcoroutines.R
import com.example.moviedatabasewithcoroutines.base.load
import com.example.moviedatabasewithcoroutines.databinding.LayoutMovieItemBinding
import com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos.MovieListItemDto
import kotlinx.android.synthetic.main.layout_movie_item.view.*

/**
 * Created by Sandeep on 24/05/20.
 */
class MovieAdapter : PagedListAdapter<MovieListItemDto, MovieAdapter.MovieItemViewHolder>(movieDiffUtils) {

    companion object {
        private val movieDiffUtils by lazy {
            object : DiffUtil.ItemCallback<MovieListItemDto>() {
                override fun areItemsTheSame(oldItem: MovieListItemDto, newItem: MovieListItemDto): Boolean {
                    return oldItem.movieId == newItem.movieId
                }

                override fun areContentsTheSame(oldItem: MovieListItemDto, newItem: MovieListItemDto): Boolean {
                    return oldItem == newItem
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LayoutMovieItemBinding>(inflater,R.layout.layout_movie_item, parent, false)
        return MovieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movieItem = getItem(position)
        holder.bind(movieItem!!)
    }

    inner class MovieItemViewHolder(private val binding : LayoutMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieItem : MovieListItemDto) {
            binding.movieItem = movieItem
            binding.ivMovieItem.load(itemView.context, movieItem.getImageUrl())
            binding.executePendingBindings()
        }
    }

}