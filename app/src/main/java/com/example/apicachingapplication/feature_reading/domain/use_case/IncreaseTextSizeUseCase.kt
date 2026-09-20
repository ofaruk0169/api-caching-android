package com.example.apicachingapplication.feature_reading.domain.use_case

import com.example.apicachingapplication.core.TextSizeOption
import com.example.apicachingapplication.feature_reading.domain.repository.TextSizeRepository
import kotlinx.coroutines.flow.first

class IncreaseTextSizeUseCase (private val repository: TextSizeRepository) {
    suspend operator fun invoke(
    ) {
        val current = repository.getTextSize().first()
        val next =
            if (current == TextSizeOption.EXTRA_LARGE) {
                current
            } else  {
                val nextSize = current.ordinal + 1
                TextSizeOption.entries[nextSize]
            }
        repository.setTextSize(next)

    }
}