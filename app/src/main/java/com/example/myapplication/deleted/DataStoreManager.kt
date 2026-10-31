package com.example.myapplication.deleted

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class DataStoreManager(private val context: Context) {
    companion object {
        val KEY_IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val KEY_USERNAME = stringPreferencesKey("username")
        val KEY_PASSWORD = stringPreferencesKey("password")
    }

    suspend fun saveLogin(username: String, password: String) {
        context.dataStore.edit { pref ->
            pref[KEY_IS_LOGGED_IN] = true
            pref[KEY_USERNAME] = username
            pref[KEY_PASSWORD] = password
        }
    }

    suspend fun deleteLogin() {
        context.dataStore.edit {
            it[KEY_IS_LOGGED_IN] = false
            it.remove(KEY_USERNAME)
            it.remove(KEY_PASSWORD)
        }
    }

    val isLoggedIn: Flow<Boolean?> = context.dataStore.data.map { it[KEY_IS_LOGGED_IN] }
    val username: Flow<String?> = context.dataStore.data.map { it[KEY_USERNAME] }
    val password: Flow<String?> = context.dataStore.data.map { it[KEY_PASSWORD] }
}