package com.example.apicachingapplication.feature_reading.data.remote.dto

import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail

data class SurahDetailDto(
    val arabic1: List<String>,
    val arabic2: List<String>,
    val audio: Audio,
    val bengali: List<String>,
    val english: List<String>,
    val revelationPlace: String,
    val surahName: String,
    val surahNameArabic: String,
    val surahNameArabicLong: String,
    val surahNameTranslation: String,
    val surahNo: Int,
    val totalAyah: Int,
    val urdu: List<String>
)

fun SurahDetailDto.toSurahDetail(): SurahDetail {
    return SurahDetail(
        surahNo = surahNo,
        arabic1 = arabic1,
        english = english,
        surahName = surahName,
        surahNameTranslation = surahNameTranslation
    )

}