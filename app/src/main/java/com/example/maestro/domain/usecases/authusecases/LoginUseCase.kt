package com.example.maestro.domain.usecases.authusecases

import com.example.maestro.data.repository.responses.authresponse.AuthResponse
import com.example.maestro.domain.repository.AuthRepositoryImpl
import com.example.maestro.utils.Resource
import okhttp3.ResponseBody
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    val repo:AuthRepositoryImpl
):LoginUseCaseImpl {
    override suspend fun invoke(email: String, password: String): Resource<AuthResponse> {
        return repo.login(email, password)
    }
}