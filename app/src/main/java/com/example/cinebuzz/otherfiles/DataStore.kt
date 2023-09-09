package com.example.cinebuzz

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

// this  class is for saving and retreving data from the preferences data store
const val DATASTORE_NAME = "user_details"
val Context.datastore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)
class DataStore(context : Context) {
    private val appContext = context.applicationContext
    // create the data store
    companion object {
        const val LOGIN_KEY = "login_key"
        const val Acess_Key = "Acess_key"
        const val USER_ID = "user_id"
     }

    suspend fun changeLoginState(value: Boolean) {
        val key1 = booleanPreferencesKey(LOGIN_KEY)
        appContext.datastore.edit {
            it[key1] = value
        }
    }

    suspend fun isLogin(): Boolean {
        val key1 = booleanPreferencesKey(LOGIN_KEY)
        return appContext.datastore.data.first()[key1] ?: false
    }

    suspend fun saveAcessToken( value: String?) {
        val key1 = stringPreferencesKey(Acess_Key)
        appContext.datastore.edit { user_details ->
            user_details[key1] = value.toString()
        }
    }

    // getAcesstoken
    suspend fun getUserDetails(): String? {
        val key1 = stringPreferencesKey(Acess_Key)
        return appContext.datastore.data.first()[key1]
    }

    suspend fun saveUserId(value : String){
        val key1 = stringPreferencesKey(USER_ID)
        appContext.datastore.edit { user_datails->
            user_datails[key1] = value
        }
    }

    suspend fun getUserId(): String? {
        val key1 = stringPreferencesKey(USER_ID)
        return appContext.datastore.data.first()[key1]
    }
}

