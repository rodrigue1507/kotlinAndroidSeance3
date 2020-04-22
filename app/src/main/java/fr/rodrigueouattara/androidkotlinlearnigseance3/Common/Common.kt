package fr.rodrigueouattara.androidkotlinlearnigseance3.Common

import fr.rodrigueouattara.androidkotlinlearnigseance3.Interface.RetrofitService
import fr.rodrigueouattara.androidkotlinlearnigseance3.Retrofit.RetrofitClient
import retrofit2.Retrofit
import retrofit2.create

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService : RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}