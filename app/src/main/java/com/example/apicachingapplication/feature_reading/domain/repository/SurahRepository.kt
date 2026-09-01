package com.example.apicachingapplication.feature_reading.domain.repository

import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDto
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.SurahEntity

interface SurahRepository {

    suspend fun getSurahs(): List<SurahDto>

    suspend fun getSurahById(surahId: String): SurahDetailDto

    suspend fun cacheSurah(surah: SurahEntity, ayah: List<AyahEntity>)
}