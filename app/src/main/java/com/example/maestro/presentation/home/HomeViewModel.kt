package com.example.maestro.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.maestro.domain.usecases.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    newsUseCase: NewsUseCase

) :ViewModel() {
    val news = newsUseCase.getNews(
        sources = listOf("bbc-news","al-jazeera-english","buzzfeed","cnn")
    ).cachedIn(viewModelScope)
}