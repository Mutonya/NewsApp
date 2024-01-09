package com.example.maestro.presentation.onBoarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.maestro.R
import com.example.maestro.presentation.onBoarding.Dimens.MediumPadding1
import com.example.maestro.presentation.onBoarding.Dimens.MediumPadding2
import com.example.maestro.presentation.onBoarding.Page
import com.example.maestro.presentation.onBoarding.Pages
import com.example.maestro.ui.theme.MaestroTheme
import com.example.maestro.ui.theme.TextMedium

@Composable
fun onBoardingComponents (modifier: Modifier, page: Page) {

    
    
    Column(modifier = Modifier) {
        
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image), contentDescription = null,
            contentScale = ContentScale.Crop
        
        
        )
        
        Spacer(modifier = Modifier.height(MediumPadding1))
        
        Text(text = page.title, modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = TextMedium
            )
        Text(text = page.description, modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = TextMedium
        )

        
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)

@Composable
fun onBoardingPreview(){

    MaestroTheme {
        onBoardingComponents(modifier = Modifier, page = Pages[0] )
    }

}