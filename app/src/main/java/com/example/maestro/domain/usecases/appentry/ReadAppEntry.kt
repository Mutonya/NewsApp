package com.example.maestro.domain.usecases.appentry

import com.example.maestro.domain.LocalUserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(private val localUserManager: LocalUserManager) {

     operator fun invoke (): Flow<Boolean> {
       return localUserManager.readAppEntry()
    }
}