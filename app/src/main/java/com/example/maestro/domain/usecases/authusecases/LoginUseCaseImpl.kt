package com.example.maestro.domain.usecases.authusecases

import com.example.maestro.data.repository.responses.authresponse.AuthResponse
import com.example.maestro.utils.Resource
import okhttp3.ResponseBody

interface LoginUseCaseImpl {

    suspend operator fun invoke(email:String,password:String):Resource<AuthResponse>
}