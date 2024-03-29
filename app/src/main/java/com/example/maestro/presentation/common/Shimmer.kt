package com.example.maestro.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.maestro.R
import com.example.maestro.presentation.common.Dimens.MediumPadding1
import com.example.maestro.ui.theme.MaestroTheme
import com.example.maestro.ui.theme.TextMedium
import com.example.maestro.ui.theme.TextTitle
import com.example.maestro.ui.theme.Tint

fun Modifier.shimmerEffects()= composed { 
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat(initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
        animation = tween(durationMillis = 1000),
        repeatMode = RepeatMode.Reverse
    ), label = ""
    ).value
    background(color = Color.Gray.copy(alpha = alpha))
}

@Composable
fun ArticleCardShimmerEffects(modifier:Modifier){
    Row (modifier = modifier){

        Box(
            modifier = Modifier
                .size(Dimens.articlecardsize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffects()

        )

        Column(verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .height(Dimens.articlecardsize)) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffects()

            )


            Row (verticalAlignment = Alignment.CenterVertically){
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(50.dp)
                        .padding(horizontal = MediumPadding1)
                        .shimmerEffects()

                )



            }

        }


    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun previewshimmer(){
    MaestroTheme {
        ArticleCardShimmerEffects(modifier = Modifier)
    }
}
