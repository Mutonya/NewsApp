package com.example.maestro.data.manager.remote

import com.example.maestro.data.manager.remote.dto.NewsResponse
import com.example.maestro.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")

    suspend fun getNews(
        @Query("page")page:Int,
        @Query("sources")sources:String,
        @Query("apikey")apiKey:String = Constants.API_KEY
    ):NewsResponse



    @GET("everything")
    suspend fun searchnews(
        @Query("q")searchQuery: String,
        @Query("page")page:Int,
        @Query("sources")sources:String,
        @Query("apikey")apiKey:String = Constants.API_KEY

    ):NewsResponse
}