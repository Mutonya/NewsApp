package com.example.maestro.data.manager.remote.dto

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)