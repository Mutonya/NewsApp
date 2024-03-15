package com.example.maestro.data.repository.responses.authresponse

data class Role(
    val id: Int,
    val type: String,
    val user_roles: UserRoles
)