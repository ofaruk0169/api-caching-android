package com.example.apicachingapplication.feature_reading.domain.model

data class SurahDetail(
    val surahNo: Int,
    val arabic1: List<String>,
    val english: List<String>,
    val surahName: String,
    val surahNameTranslation: String
)
