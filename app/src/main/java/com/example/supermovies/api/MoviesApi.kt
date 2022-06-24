package com.example.supermovies.api

import com.example.supermovies.api.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://apache.superology.dev/"

interface MoviesApi {
    @GET("android-dev/movies")
    fun getMovies(): Call<List<MovieModel>>
}