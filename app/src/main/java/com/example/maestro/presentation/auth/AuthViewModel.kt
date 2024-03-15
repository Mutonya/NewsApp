package com.example.maestro.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maestro.data.repository.responses.authresponse.AuthResponse
import com.example.maestro.domain.usecases.authusecases.LoginUseCaseImpl
import com.example.maestro.utils.Resource
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(

    private val useCase:LoginUseCaseImpl

):ViewModel() {

    private val _loginResponse:MutableLiveData<Resource<AuthResponse>> = MutableLiveData()
    val loginResponse:LiveData<Resource<AuthResponse>> get() = _loginResponse

    fun login(email:String,password:String) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = useCase.invoke(email, password)
    }

    
}