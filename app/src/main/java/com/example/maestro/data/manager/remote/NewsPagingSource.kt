package com.example.maestro.data.manager.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.maestro.domain.models.Article

class NewsPagingSource (

    private val newsApi: NewsApi,
    private val spurces:String
):PagingSource<Int,Article>(){

    private var totalnescount = 0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {

        return state.anchorPosition?.let {
            val anchorpage = state.closestPageToPosition(it)
            anchorpage?.prevKey?.plus(1)?:anchorpage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        val page = params.key?: 1
        return try {

            val newsresponse = newsApi.getNews(page = page, sources = spurces)
            totalnescount += newsresponse.articles.size
            val article = newsresponse.articles.distinctBy { it.title } //remove duplicate
            LoadResult.Page(
                data = article,
                nextKey = if (totalnescount == newsresponse.totalResults) null else page +1,
                prevKey = null
            )

        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}