package com.example.apicachingapplication.feature_reading.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SurahEntity(
    @PrimaryKey
    val surahNo: Int,
    val surahName: String,
    val surahNameTranslation: String
)