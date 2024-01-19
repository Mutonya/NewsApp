package com.example.maestro.domain.usecases.news

import androidx.paging.PagingData
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources:List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(source = sources)
    }
}