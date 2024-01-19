package com.example.maestro.presentation.details

import com.example.maestro.domain.models.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle (val article: Article) : DetailsEvent()

    object RemoveSideEffect:DetailsEvent()
}