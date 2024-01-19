package com.example.maestro.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.maestro.R
import com.example.maestro.domain.models.Article
import com.example.maestro.domain.models.Source
import com.example.maestro.presentation.common.Dimens.ExtraSmallPadding
import com.example.maestro.presentation.common.Dimens.SmallIconSixe
import com.example.maestro.presentation.common.Dimens.articlecardsize
import com.example.maestro.ui.theme.TextMedium
import com.example.maestro.ui.theme.TextTitle
import com.example.maestro.ui.theme.Tint

@Composable
fun ArticleCard(
    modifier: Modifier,
    article: Article,
    onClick:()->Unit
){
    val context = LocalContext.current
    Row (modifier = modifier.clickable { onClick() }){

        AsyncImage(
            modifier = Modifier
                .size(articlecardsize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context = context)
                .data(article.urlToImage)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.maestro),
            contentDescription =null,
            contentScale = ContentScale.Crop
        )



        Column(verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .height(articlecardsize)) {
            
            Text(text = article.title, style = MaterialTheme.typography.bodyMedium,
                color = TextTitle,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)


            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = TextMedium)
                
                Spacer(modifier =Modifier.width(ExtraSmallPadding) )
                Icon(painter = painterResource(id = R.drawable.ic_time),
                    contentDescription =null,
                    modifier = Modifier.size(SmallIconSixe),
                    tint = Tint
                )
                Spacer(modifier =Modifier.width(ExtraSmallPadding) )
                Text(text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = TextMedium)



            }

        }


    }
}

@Composable
@Preview
fun previewArticleCard(){
    ArticleCard(modifier = Modifier, article =Article(
         author = "SEC approves bitcoin ETFs (for real this time)",
         content = "The Securities and Exchange Commission has approved\r\n the applications of 11 spot bitcoin ETFs in a highly anticipated decision that will make it much easier for people to dabble in cryptocurrency in… [+1453 chars]",
     description = "The Securities and Exchange Commission has approved\r\n the applications of 11 spot bitcoin ETFs in a highly anticipated decision that will make it much easier for people to dabble in cryptocurrency investing without directly buying and holding bitcoin. The app…",
     publishedAt = "2024-01-10T22:41:25Z",
     source = Source(id ="the-verge ", name = "the-verge") ,
     title ="How to sue a hacker using Bitcoin" ,
     url  = "https://www.theverge.com/2024/1/10/24033166/bitcoin-crypto-ryan-dellone-lawsuit-hacker",
     urlToImage =""
    ) ) {

    }
}


