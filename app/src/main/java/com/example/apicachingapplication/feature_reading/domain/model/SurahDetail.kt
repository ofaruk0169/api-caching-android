package com.example.apicachingapplication.feature_reading.domain.model


// this is UI facing presentation layer

data class SurahDetail(
    val surahNo: Int,
    val arabic1: List<String>,
    val english: List<String>,
    val surahName: String,
    val surahNameTranslation: String,
    val isCached : Boolean = false
)
