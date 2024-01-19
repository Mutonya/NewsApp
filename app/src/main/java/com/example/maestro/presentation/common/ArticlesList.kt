package com.example.maestro.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.maestro.domain.models.Article
import com.example.maestro.presentation.common.Dimens.MediumPadding1
import com.example.maestro.presentation.common.Dimens.Roundedcorner
import com.example.maestro.utils.Constants

@Composable
fun ArticlesList (
    modifier: Modifier,
    article: LazyPagingItems<Article>,
    onClick:(Article) ->Unit

){
    
    val handlePagingResult = handlingPagingResult(article = article)

    if (handlePagingResult){
        LazyColumn(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = Roundedcorner)
            ){
            items(count = article.itemCount){
                article[it]?.let {article->
                    ArticleCard(modifier = Modifier, article = article,onClick = { onClick(article) })

                    }
                }
            }
        }
    }


@Composable
fun ArticlesLists (
    modifier: Modifier,
    article: List<Article>,
    onClick:(Article) ->Unit

){


    if (article.isEmpty()){
        EmptyScreen()
    }



        LazyColumn(modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = Roundedcorner)
        ){
            items(
                count = article.size,
            ) {
                article[it].let { article ->
                    ArticleCard(modifier = Modifier,article = article, onClick = {onClick(article)})
                }


            }
        }

}




@Composable
fun handlingPagingResult(
    article: LazyPagingItems<Article>,
):Boolean{
    val loadState = article.loadState
    val error = when{
        loadState.refresh is LoadState.Error  -> loadState.refresh as LoadState.Error
        loadState.append is LoadState.Error ->loadState.append as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error

        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading ->{
            ShimmerEffect()
            false
        }
        error !=null ->{
            EmptyScreen()
            false
        }

        else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffects(modifier = Modifier.padding(horizontal = Dimens.MediumPadding1))
        }
    }
}