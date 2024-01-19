package com.example.maestro.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.maestro.domain.LocalUserManager
import com.example.maestro.utils.Constants.APP_ENTRYS
import com.example.maestro.utils.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserManagerImpl @Inject constructor(
    private val context:Context
):LocalUserManager {
    override suspend fun saveAppEntry() {
        context.datastore.edit {
            it[PreferencesKeys.App_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
       return context.datastore.data.map {
           it[PreferencesKeys.App_ENTRY]?: false
       }
    }
}

private val Context.datastore :DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val App_ENTRY  = booleanPreferencesKey(name = APP_ENTRYS)
}