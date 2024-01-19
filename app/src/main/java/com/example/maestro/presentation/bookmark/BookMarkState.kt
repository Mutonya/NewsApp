package com.example.maestro.presentation.bookmark

import com.example.maestro.domain.models.Article

data class BookMarkState (
    val article: List<Article> = emptyList()
)
