package com.example.maestro.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.maestro.domain.usecases.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel@Inject constructor(
   private val nesUseCase:NewsUseCase
):ViewModel() {

private val _state = mutableStateOf(SearchState())
    val state:State<SearchState> = _state

    fun onEvent(events: SearchEvents){

        when(events){
            is SearchEvents.UpdateSeachQuerry ->{
                _state.value = state.value.copy(
                    searchQuerry = events.searchQuery
                )

            }
            is SearchEvents.SearchNews ->{

                searchNews()

            }
        }

    }

    private fun searchNews() {
        val articles = nesUseCase.searchNews(searchquerry =state.value.searchQuerry,
            sources = listOf("bbc-news","al-jazeera-english","buzzfeed","cnn")).cachedIn(viewModelScope)

        _state.value = state.value.copy(
            articles = articles
        )
    }

}