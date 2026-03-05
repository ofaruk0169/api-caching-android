package com.example.apicachingapplication.feature_reading.data.repository

import com.example.apicachingapplication.feature_reading.data.remote.QuranPagesApi
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDto
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import javax.inject.Inject

class SurahRepositoryImpl @Inject constructor(
    private val api: QuranPagesApi
): SurahRepository {
    override suspend fun getSurahs(): List<SurahDto> {
        return api.getSurahs()
    }

    override suspend fun getSurahById(surahId: String): SurahDetailDto {
        return api.getSurahById(surahId)
    }
}