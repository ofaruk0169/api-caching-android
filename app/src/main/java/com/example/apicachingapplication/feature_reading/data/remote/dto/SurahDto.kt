package com.example.apicachingapplication.feature_reading.data.remote.dto

data class SurahDto(
    val revelationPlace: String,
    val surahName: String,
    val surahNameArabic: String,
    val surahNameArabicLong: String,
    val surahNameTranslation: String,
    val totalAyah: Int
)