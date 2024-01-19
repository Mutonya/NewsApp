package com.example.maestro.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.maestro.data.local.NewsDao
import com.example.maestro.data.manager.remote.NewsApi
import com.example.maestro.data.manager.remote.NewsPagingSource
import com.example.maestro.data.manager.remote.SearchNewsPagingSource
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepositoryImpl (
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
):NewsRepository{
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
return Pager(
    config = PagingConfig(pageSize = 10),
    pagingSourceFactory = {
        NewsPagingSource(
            newsApi= newsApi,
            spurces = source.joinToString (separator = ",")
        )
    }
).flow

    }

    override fun searchnews(searchQuerry: String, source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuerry=searchQuerry,
                    newsApi= newsApi,
                    spurces = source.joinToString (separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticles(article: Article) {
        newsDao.upsert(article)    }

    override suspend fun deleteArticle(article: Article) {
newsDao.delete(article)    }

    override fun selectArticle(): Flow<List<Article>> {
      return newsDao.getArticles().onEach { it}
    }

    override suspend fun selectArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }


}