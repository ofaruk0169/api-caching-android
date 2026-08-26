package com.example.apicachingapplication.feature_reading.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class SurahDetail(
    val surahNo: Int,
    val arabic1: List<String>,
    val english: List<String>,
    val surahName: String,
    val surahNameTranslation: String
)
