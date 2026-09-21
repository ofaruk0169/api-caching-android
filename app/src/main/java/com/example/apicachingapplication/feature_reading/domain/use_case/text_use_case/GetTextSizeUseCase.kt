package com.example.apicachingapplication.feature_reading.domain.use_case.text_use_case

import com.example.apicachingapplication.core.TextSizeOption
import com.example.apicachingapplication.feature_reading.domain.repository.TextSizeRepository
import kotlinx.coroutines.flow.Flow

class GetTextSizeUseCase(
    private val repository: TextSizeRepository
) {
    operator fun invoke(): Flow<TextSizeOption> {
        return repository.getTextSize()
    }
}