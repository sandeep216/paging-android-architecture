package com.example.moviedatabasewithcoroutines.base

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sandeep on 23/05/20.
 */
object RetrofitBuilder {

    fun getRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(HttpLoggingInterceptor())
        httpClient.addInterceptor(AuthInterceptor())

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    class AuthInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val builder = originalRequest.newBuilder()
            val authorisedRequest = builder
                .header(Constants.AUTH_TOKEN, Constants.USER_AUTH_TOKEN)
                .build()

            return chain.proceed(originalRequest)
        }

    }
}