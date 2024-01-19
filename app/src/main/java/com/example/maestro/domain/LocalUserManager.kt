package com.example.maestro.data.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {


    suspend fun saveAppEntry()

    fun readAppEntry():Flow<Boolean>
}