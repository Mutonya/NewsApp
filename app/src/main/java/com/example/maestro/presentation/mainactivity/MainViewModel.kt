package com.example.maestro.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maestro.domain.usecases.appentry.AppEntryUseCase
import com.example.maestro.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
):ViewModel() {

     var splashCondition by mutableStateOf(true)
         private set

    var startdestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {

        appEntryUseCase.readAppEntry().onEach { startfromHome ->

            startdestination = if (startfromHome){
                Route.NewsNavigation.route
            }else{
                Route.AppStartNavigation.route
            }
            delay(500)
            splashCondition= false

        }.launchIn(viewModelScope)
    }
    }


