package com.example.maestro.data.repository.responses.authresponse

data class Currentuser(
    val Roles: List<Role>,
    val appleId: Any,
    val birthday: String,
    val blocked: Boolean,
    val countrydial: Any,
    val default_category: Int,
    val email: String,
    val id: Int,
    val mobile: String,
    val mobileverification: Boolean,
    val password: String,
    val profilepicture: String,
    val status: Boolean,
    val twaaIts: Int,
    val twaausername: String,
    val username: String
)