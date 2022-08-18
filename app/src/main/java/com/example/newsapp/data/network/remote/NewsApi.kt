package com.example.newsapp.data.network.remote

import com.example.newsapp.BuildConfig
import com.example.newsapp.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("q") search:String,
        @Query("apiKey") apiKey:String = BuildConfig.API_KEY,
    ) : Response<News>
}