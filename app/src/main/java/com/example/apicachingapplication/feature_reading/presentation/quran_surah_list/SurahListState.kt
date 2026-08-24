package com.example.apicachingapplication.feature_reading.presentation.quran_surah_list

import com.example.apicachingapplication.feature_reading.domain.model.SurahListItem

data class SurahListState(
    val isLoading: Boolean = false,
    val surahs: List<SurahListItem> = emptyList(),
    val error: String = ""
)