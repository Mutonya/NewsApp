package com.example.maestro.presentation.search

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.maestro.domain.models.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (

    val searchQuerry:String ="",
    val articles:Flow<PagingData<Article>>? = null
)