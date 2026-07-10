package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SurahEntity(
    @PrimaryKey
    val surahNo: Int,
    val arabic1: List<String>,
    val english: List<String>,
    val surahName: String,
    val surahNameTranslation: String
)