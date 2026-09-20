package com.example.apicachingapplication.feature_reading.domain.repository

interface TextSizeRepository {

    suspend fun increaseSp(): String

    suspend fun decreaseSp(username: String)

    suspend fun getTextSize()

    suspend fun setTextSize()
}