package com.example.maestro.domain.usecases.news

import com.example.maestro.data.local.NewsDao
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.repository.NewsRepository

class UpsetArticle (
    private val newsRepository: NewsRepository
){


    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticles(article)
    }
}