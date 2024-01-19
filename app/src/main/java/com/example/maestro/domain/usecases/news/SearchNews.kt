package com.example.maestro.domain.usecases.news

import androidx.paging.PagingData
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.repository.NewsRepository

class SearchNews(private val newsRepository:NewsRepository) {



    operator fun invoke(searchquerry:String,sources:List<String>): kotlinx.coroutines.flow.Flow<PagingData<Article>> {
        return newsRepository.searchnews(searchQuerry = searchquerry,source = sources)
    }
}