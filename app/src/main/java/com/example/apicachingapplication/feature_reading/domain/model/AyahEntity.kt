package com.example.apicachingapplication.feature_reading.domain.model

import androidx.room.Entity

@Entity(primaryKeys = arrayOf("surahNo", "ayahNo"))
data class AyahEntity (
    val surahNo: Int,
    val ayahNo: Int,
    val english: String,
    val arabic1: String
)