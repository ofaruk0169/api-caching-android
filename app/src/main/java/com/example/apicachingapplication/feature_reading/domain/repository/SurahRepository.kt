package com.example.apicachingapplication.feature_reading.domain.repository

import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.Surah
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail
import com.example.apicachingapplication.feature_reading.domain.model.SurahEntity
import kotlinx.coroutines.flow.Flow

interface SurahRepository {

    suspend fun getSurahs(): List<Surah>

    suspend fun getSurahById(surahId: String): SurahDetail

    suspend fun getSurahDtoById(surahId: String): SurahDetailDto

    suspend fun cacheSurah(surah: SurahEntity, ayah: List<AyahEntity>)

    fun getCachedSurahs(): Flow<List<Int>>

    suspend fun cacheAllSurah(surah: SurahEntity, ayah: List<AyahEntity>)

}