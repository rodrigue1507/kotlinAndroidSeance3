package fr.rodrigueouattara.androidkotlinlearnigseance3.Interface

import retrofit2.Call
import fr.rodrigueouattara.androidkotlinlearnigseance3.models.Movie
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel" )
    fun getMovieList(): Call<MutableList<Movie>>
}