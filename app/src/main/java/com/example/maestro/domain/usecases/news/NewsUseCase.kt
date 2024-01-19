package com.example.maestro.domain.usecases.news

data class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsetArticle: UpsetArticle,
    val deleteArticle: DeleteArticle,
    val selectArticle: SelectArticle,
    val selectedArticle: SelectedArticle

)
