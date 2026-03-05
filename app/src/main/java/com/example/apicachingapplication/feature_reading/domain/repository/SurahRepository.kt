package com.example.apicachingapplication.feature_reading.domain.repository

import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDto

interface SurahRepository {

    suspend fun getSurahs(): List<SurahDto>

    suspend fun getSurahById(surahId: String): SurahDetailDto
}