package com.example.apicachingapplication.feature_reading.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto

@Entity
data class SurahEntity(
    @PrimaryKey
    val surahNo: Int,
    val surahName: String,
    val surahNameTranslation: String,
    val totalAyah: Int
)

fun SurahEntity.toSurah(): Surah {
    return Surah(
        surahNumber = surahNo,
        surahName = surahName,
        totalAyah = totalAyah
    )
}