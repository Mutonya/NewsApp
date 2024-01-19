package com.example.maestro.domain.usecases.news

import com.example.maestro.data.local.NewsDao
import com.example.maestro.domain.models.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}