package com.example.apicachingapplication.feature_reading.data.repository

import com.example.apicachingapplication.feature_reading.data.data_source.QuranDao
import com.example.apicachingapplication.feature_reading.data.remote.QuranPagesApi
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDto
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.SurahEntity
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import javax.inject.Inject

class SurahRepositoryImpl @Inject constructor(
    private val api: QuranPagesApi,
    private val dao: QuranDao
): SurahRepository {
    override suspend fun getSurahs(): List<SurahDto> {
        return api.getSurahs()
    }

    override suspend fun getSurahById(surahId: String): SurahDetailDto {
        return api.getSurahById(surahId)
    }

    override suspend fun cacheSurah(surah: SurahEntity, ayah: List<AyahEntity>) {
        dao.cacheSurah(surah, ayah)
    }
}