package com.example.apicachingapplication.feature_reading.presentation.quran_reader

import com.example.apicachingapplication.feature_reading.domain.model.Surah
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail

data class SurahDetailState(
    val isLoading: Boolean = false,
    val surah: SurahDetail? = null,
    val error: String = ""
)