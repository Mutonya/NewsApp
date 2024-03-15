package com.example.maestro.domain.repository

import com.example.maestro.data.repository.responses.authresponse.AuthResponse
import com.example.maestro.utils.Resource
import okhttp3.ResponseBody

interface AuthRepositoryImpl {

    suspend fun login(email:String,password:String): Resource<AuthResponse>
}