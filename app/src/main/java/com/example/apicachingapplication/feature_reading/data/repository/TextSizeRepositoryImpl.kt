package com.example.apicachingapplication.feature_reading.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.apicachingapplication.core.TextSizeOption
import com.example.apicachingapplication.feature_reading.domain.repository.TextSizeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class TextSizeRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : TextSizeRepository {

    val TEXTSIZE_KEY = stringPreferencesKey("textsize")


    override fun getTextSize(): Flow<TextSizeOption> {
        return dataStore.data.map { preferences ->
            TextSizeOption.valueOf(preferences[TEXTSIZE_KEY] ?: TextSizeOption.MEDIUM.name)
        }
    }


    override suspend fun setTextSize() {

    }

}