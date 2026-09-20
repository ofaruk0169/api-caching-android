package com.example.apicachingapplication.feature_reading.domain.use_case

import com.example.apicachingapplication.feature_reading.domain.repository.TextSizeRepository

class IncreaseTextSizeUseCase (private val repository: TextSizeRepository) {
    suspend operator fun invoke() {
        val current = repository.getTextSize() // or however you read the current value
        val next = /* current, one step up, clamped at EXTRA_LARGE */
            repository.setTextSize(next)
    }
}