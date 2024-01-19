package com.example.maestro.presentation.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maestro.domain.usecases.appentry.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
):ViewModel() {

    fun onEvent(event:OnBoardingEvents){
        when (event){
            is OnBoardingEvents.SaveAppEntry ->{
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {

        viewModelScope.launch {
            appEntryUseCase.saveAppEntry()

        }

    }
}