package com.example.maestro.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.usecases.news.GetSavedArticles
import com.example.maestro.domain.usecases.news.NewsUseCase
import com.example.maestro.utils.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsVewModel  @Inject constructor(
    private val newsUseCse:NewsUseCase,

):ViewModel(){

    var sideEffect by mutableStateOf<UIComponent?>(null)

        private set

    fun onEvent(event: DetailsEvent){

        when(event){
            is DetailsEvent.UpsertDeleteArticle ->{

                viewModelScope.launch {
                    val articles = newsUseCse.selectedArticle(url = event.article.url)

                    if(articles == null){
                        upsertArticle(article = event.article)
                    }else{
                        deletearticle(article = event.article )
                    }

                }
            }
            is DetailsEvent.RemoveSideEffect ->{
                sideEffect = null
            }

            else -> {}
        }

    }

    private suspend fun deletearticle(article: Article) {
        newsUseCse.deleteArticle(article = article)
        sideEffect = UIComponent.Toast("\"Article Deleted\"")

    }

    private suspend fun upsertArticle(article: Article) {
       newsUseCse.upsetArticle(article =article )
        sideEffect = UIComponent.Toast("Article Saved")

    }
}