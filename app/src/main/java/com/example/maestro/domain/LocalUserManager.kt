package com.example.maestro.domain

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {


    suspend fun saveAppEntry()

    fun readAppEntry():Flow<Boolean>
}