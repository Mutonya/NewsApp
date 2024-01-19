package com.example.maestro.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.maestro.R
import com.example.maestro.domain.models.Article
import com.example.maestro.presentation.common.ArticlesLists
import com.example.maestro.presentation.common.Dimens
import com.example.maestro.presentation.common.EmptyScreen
import com.example.maestro.presentation.navgraph.Route

@Composable

fun BookMarkScreen(

    state: BookMarkState,
    navigateToDetails:(Article) ->Unit
){

    if(state.article.isEmpty()){
        EmptyScreen()
    }

    Column (modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(
            top = Dimens.MediumPadding1,
            end = Dimens.MediumPadding1,
            start = Dimens.MediumPadding1
        )){
        Text(text = "BookMark", style = MaterialTheme.typography.displayMedium.copy(
            fontWeight = FontWeight.Bold
        ),
            color = colorResource(id = R.color.text_title))
        
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        ArticlesLists(modifier = Modifier, article =state.article , onClick = navigateToDetails
         )

    }

}