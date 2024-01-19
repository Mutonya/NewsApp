package com.example.maestro.domain.usecases.appentry

import com.example.maestro.domain.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {

   suspend  operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}