package com.example.moviedatabasewithcoroutines.feature.movie_list.data.dtos

import android.os.Parcelable
import com.example.moviedatabasewithcoroutines.base.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Sandeep on 23/05/20.
 */

@Parcelize
data class MovieResponseDtos(
    @SerializedName("page")
    var pages : Int,

    @SerializedName("total_results")
    var totalCount : Int,

    @SerializedName("total_pages")
    var totalPages : Int,

    @SerializedName("results")
    var results : List<MovieListItemDto>
) : Parcelable


@Parcelize
data class MovieListItemDto(
    @SerializedName("popularity")
    var popularity : Float,

    @SerializedName("vote_count")
    var voteCount : Int,

    @SerializedName("video")
    var video : Boolean,

    @SerializedName("poster_path")
    var posterPath : String,

    @SerializedName("id")
    var movieId : Int,

    @SerializedName("adult")
    var isAdult : Boolean,

    @SerializedName("backdrop_path")
    var backDropPath : String,

    @SerializedName("original_language")
    var originalLanguage : String,

    @SerializedName("original_title")
    var originalTitle : String,

    @SerializedName("title")
    var title : String,

    @SerializedName("vote_average")
    var voteAverage : Float,

    @SerializedName("overview")
    var overview : String,

    @SerializedName("release_date")
    var releaseDate : String

) : Parcelable {

    fun getImageUrl() : String {
        return Constants.IMAGE_BASE_URL + posterPath
    }
}