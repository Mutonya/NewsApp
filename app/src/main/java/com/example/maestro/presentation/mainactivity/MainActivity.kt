package com.example.maestro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.maestro.presentation.MainViewModel
import com.example.maestro.presentation.navgraph.NavGraph
import com.example.maestro.ui.theme.MaestroTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen()
//            .apply {
//            setKeepOnScreenCondition{
//                viewModel.splashCondition
//            }
//        }


        setContent {
            MaestroTheme {

                val isSysteminDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()


                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSysteminDarkMode
                    )
                }

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){

                    val startDestination = viewModel.startdestination
                    NavGraph(startDestination = startDestination)

                }
            }
        }
    }
}

