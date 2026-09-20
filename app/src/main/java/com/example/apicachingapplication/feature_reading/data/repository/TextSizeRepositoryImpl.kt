package com.example.apicachingapplication.feature_reading.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

class TextSizeRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) {
}