package com.example.maestro.domain.repository

import com.example.maestro.data.manager.remote.NewsApi
import com.example.maestro.data.repository.responses.authresponse.AuthResponse
import com.example.maestro.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val service:NewsApi,
    private val dispatcher:CoroutineDispatcher
):AuthRepositoryImpl {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        val  response = withContext(dispatcher){
            try {
                val response = service.login(email, password)
                Resource.Success(response)
            }catch (e:Exception){
                Resource.Failure(false,0,e.message)
            }
        }

        return response
    }


}