package com.example.apicachingapplication.feature_reading.data.remote.dto

import com.example.apicachingapplication.feature_reading.domain.model.Surah

data class SurahDto(
    val revelationPlace: String,
    val surahName: String,
    val surahNameArabic: String,
    val surahNameArabicLong: String,
    val surahNameTranslation: String,
    val totalAyah: Int
)

fun SurahDto.toSurah(): Surah {
    return Surah(
        surahName = surahName,
        totalAyah = totalAyah
    )
}