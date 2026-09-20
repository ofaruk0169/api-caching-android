package com.example.apicachingapplication.feature_reading.domain.repository

import com.example.apicachingapplication.core.TextSizeOption
import kotlinx.coroutines.flow.Flow

interface TextSizeRepository {
    fun getTextSize(): Flow<TextSizeOption>
    suspend fun setTextSize(option: TextSizeOption)
}