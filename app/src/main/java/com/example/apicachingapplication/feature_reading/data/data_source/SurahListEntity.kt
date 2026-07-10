package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SurahListEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val types: String,
    val abilities: String,
    val height: String,
    val spriteUrl: String?
)