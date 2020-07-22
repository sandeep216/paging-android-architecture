package com.example.moviedatabasewithcoroutines.base

/**
 * Created by Sandeep on 19/04/20.
 */
data class Resource<T>(val status: Status, val data: T? = null, val message: String? = null) {
    companion object {
        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING)
        }

        fun <T> success(data: T?): Resource<T?> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> failure(message: String?) : Resource<T> {
            return Resource(Status.FAIL, message = message)
        }

    }
}

enum class Status {
    LOADING,
    SUCCESS,
    FAIL
}