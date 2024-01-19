package com.example.maestro.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.maestro.R
import com.example.maestro.domain.models.Article
import com.example.maestro.presentation.common.ArticlesList
import com.example.maestro.presentation.common.Dimens
import com.example.maestro.presentation.common.SearchBar
import com.example.maestro.presentation.navgraph.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles:LazyPagingItems<Article>,
    navigateToSearch:() ->Unit,
    navigateToDetails:(Article) ->Unit
    ){


    val titles by remember {
        derivedStateOf {
            if (articles.itemCount >10){
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 2, endInclusive = 9))
                    .joinToString (separator = "\uD83d\uDFE5"){it.title}
            }else{
                    ""
            }
        }
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = Dimens.MediumPadding1)
        .statusBarsPadding()) {

//        Image(painter = painterResource(id = R.drawable.maestro), contentDescription = null,
//            modifier = Modifier
//                .width(150.dp)
//                .height(30.dp)
//                .padding(horizontal = Dimens.MediumPadding1)
//            )
//
//
//        Spacer(modifier =Modifier.height(Dimens.MediumPadding1) )

        SearchBar(modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            text = "", readOnly =true ,
            onValueChange ={}, 
            onclick = navigateToSearch,
            onSearch = {} )
        
        Spacer(modifier =Modifier.height(Dimens.MediumPadding1) )

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.MediumPadding1)
                .basicMarquee(),
                fontSize = 12.sp,
            color = Color.Black
        )
        Spacer(modifier =Modifier.height(Dimens.MediumPadding1) )


        ArticlesList(modifier = Modifier.padding(horizontal =Dimens.MediumPadding1 ),
            article = articles, onClick = {
                navigateToDetails(it)


            }  )






    }
}