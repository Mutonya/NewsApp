package com.example.maestro.data.manager.remote.dto

import com.example.maestro.domain.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)