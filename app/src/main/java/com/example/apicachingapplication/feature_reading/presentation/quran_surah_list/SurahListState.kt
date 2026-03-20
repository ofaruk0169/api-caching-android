package com.example.apicachingapplication.feature_reading.presentation.quran_surah_list

import com.example.apicachingapplication.feature_reading.domain.model.Surah

data class SurahListState(
    val isLoading: Boolean = false,
    val surahs: List<Surah> = emptyList(),
    val error: String = ""
)