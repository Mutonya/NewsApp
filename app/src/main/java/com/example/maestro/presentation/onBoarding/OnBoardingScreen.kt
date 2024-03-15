package com.example.maestro.presentation.onBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.maestro.presentation.common.Dimens.MediumPadding2
import com.example.maestro.presentation.common.Dimens.pagerwidth
import com.example.maestro.presentation.common.NewsButton
import com.example.maestro.presentation.common.NewsTextButton
import com.example.maestro.presentation.onBoarding.components.PageIndicator
import com.example.maestro.presentation.onBoarding.components.onBoardingComponents
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(

    events: (OnBoardingEvents) ->Unit
){

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween){
        val pagerState = rememberPagerState(initialPage = 0){
            Pages.size
        }

        val buttonstate = remember{
            derivedStateOf {
                when (pagerState.currentPage){
                    0 -> listOf("","Set Up Account")
                    1 -> listOf("","Set Up Account")
                    2 -> listOf("","Set Up Account")
                    3 -> listOf("","Set Up Account")
                    4 -> listOf("","Finish")
                    else -> listOf("","")
                }
            }
        }

        HorizontalPager(state = pagerState) {index ->
            onBoardingComponents(modifier = Modifier.weight(1f),page = Pages[index])



        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.weight(1f,false)
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center
        ){
            PageIndicator(
                modifier = Modifier.width(pagerwidth),
                pageSize = Pages.size,
                selectedPage =pagerState.currentPage
            )
        }

//        Spacer(modifier = Modifier.weight(1f))



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center
        ){


            Row (verticalAlignment = Alignment.CenterVertically){

                val scpoe = rememberCoroutineScope()
                if (buttonstate.value[0].isNotEmpty()){

                    NewsTextButton(text = buttonstate.value[0], onClick = {
                        scpoe.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage -1)
                        }
                    })

                }
                NewsButton(text = buttonstate.value[1], onClick = {

                    scpoe.launch {
                        if (pagerState.currentPage ==4){

                            events(OnBoardingEvents.SaveAppEntry)

                        }else{
                            pagerState.animateScrollToPage(page = pagerState.currentPage +1)
                        }
                    }
                })





            }

        }
        Spacer(modifier =Modifier.weight(0.5f))

    }

}

@Composable
@Preview

fun previewOnBoarding(){
    OnBoardingScreen ({ null })
}
