package com.example.apicachingapplication.feature_reading.data.remote.dto

import com.example.apicachingapplication.feature_reading.domain.model.Surah
import com.example.apicachingapplication.feature_reading.domain.model.SurahEntity

data class SurahDto(
    val revelationPlace: String,
    val surahName: String,
    val surahNameArabic: String,
    val surahNameArabicLong: String,
    val surahNameTranslation: String,
    val totalAyah: Int
)



fun SurahDto.toSurah(surahNumber: Int): Surah {
    return Surah(
        surahName = surahName,
        totalAyah = totalAyah,
        surahNumber = surahNumber
    )
}

fun SurahDto.toSurahEntity(surahNumber: Int): SurahEntity {
    return SurahEntity(
        surahName = surahName,
        totalAyah = totalAyah,
        surahNameTranslation = surahNameTranslation,
        surahNo = surahNumber
    )
}