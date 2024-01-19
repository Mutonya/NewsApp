package com.example.maestro.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.maestro.domain.models.Article
import com.example.maestro.presentation.common.ArticlesList
import com.example.maestro.presentation.common.Dimens
import com.example.maestro.presentation.common.SearchBar
import com.example.maestro.presentation.navgraph.Route

@Composable
fun SearchScreen(

    state: SearchState,
    events: (SearchEvents) ->Unit,
    navigateToDetails:(Article)->Unit
){

    Column(modifier = Modifier
        .padding(
            top = Dimens.MediumPadding1,
            start = Dimens.MediumPadding1,
            end = Dimens.MediumPadding1
        )
        .statusBarsPadding()
        .fillMaxSize()) {

        SearchBar(modifier = Modifier, text =state.searchQuerry ,
            readOnly =false ,
            onValueChange ={events(SearchEvents.UpdateSeachQuerry(it))},
            onSearch ={events(SearchEvents.SearchNews)}
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        state.articles?.let {
            val article = it.collectAsLazyPagingItems()
            ArticlesList(modifier = Modifier, article =article , onClick = {
                navigateToDetails(it)
            })
        }

    }

}