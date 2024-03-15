package com.example.maestro.data.repository.responses.authresponse

data class AuthResponse(
    val accesstoken: String,
    val auth: Boolean,
    val currentuser: Currentuser,
    val message: String,
    val success: String
)