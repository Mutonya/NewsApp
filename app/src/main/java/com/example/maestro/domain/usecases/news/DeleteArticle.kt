package com.example.maestro.domain.usecases.news

import com.example.maestro.data.local.NewsDao
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.repository.NewsRepository

class DeleteArticle (
    private val newsRepository: NewsRepository
) {


    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}