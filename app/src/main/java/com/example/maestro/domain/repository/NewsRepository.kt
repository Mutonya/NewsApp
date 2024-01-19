package com.example.maestro.domain.repository

import androidx.paging.PagingData
import com.example.maestro.domain.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {


    fun getNews(source:List<String>):Flow<PagingData<Article>>
    fun searchnews(searchQuerry:String,source:List<String>):Flow<PagingData<Article>>

    suspend fun upsertArticles(article:Article)
    suspend fun deleteArticle(article: Article)
     fun  selectArticle():Flow<List<Article>>

     suspend fun selectArticle(url:String):Article?


}