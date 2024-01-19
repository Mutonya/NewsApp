package com.example.maestro.domain.usecases.news

import com.example.maestro.data.local.NewsDao
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val newsRepository: NewsRepository
){


     operator fun invoke():Flow<List<Article>>{
        return newsRepository.selectArticle()
    }
}