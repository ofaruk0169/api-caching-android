package com.example.apicachingapplication.feature_reading.data.repository

import android.util.Log
import com.example.apicachingapplication.feature_reading.data.data_source.QuranDao
import com.example.apicachingapplication.feature_reading.data.remote.QuranPagesApi
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurah
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurahDetail
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.SurahEntity
import com.example.apicachingapplication.feature_reading.domain.model.toSurah
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import com.example.apicachingapplication.feature_reading.domain.model.Surah
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurahEntity
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail

class SurahRepositoryImpl @Inject constructor(
    private val api: QuranPagesApi,
    private val dao: QuranDao
): SurahRepository {

    override suspend fun getSurahs(): List<Surah> {
        val cachedSurahs = dao.getAllSurahs().first()
        return if (cachedSurahs.isEmpty()) {
            val apiResponse = api.getSurahs()
            val surahs = apiResponse.mapIndexed { index, item -> item.toSurah(index + 1) }
            val entities = apiResponse.mapIndexed { index, item ->
                item.toSurahEntity(index + 1)
            }
            dao.cacheSurahList(entities)
            surahs
        } else {
            cachedSurahs.map {
                entity -> entity.toSurah()
            }
        }
    }

    override suspend fun getSurahById(surahId: String): SurahDetail {
        val surahIdInt = surahId.toInt()
        val cachedSurah = dao.getSurahEntityById(surahIdInt) ?: throw IllegalStateException("Surah $surahIdInt has ayahs but no SurahEntity row")
        val cachedAyahs = dao.getAyahEntityById(surahIdInt)
        return if (cachedAyahs.isEmpty()) {
            Log.d("SurahDetail", "Surah $surahIdInt not cached — fetching from API")
            val surah = api.getSurahById(surahId).toSurahDetail()
            surah
        } else {
            Log.d("SurahDetail", "Surah $surahIdInt found in cache — loading from Room")
            val arabicTexts = cachedAyahs.map { ayah -> ayah.arabic1 }
            val englishTexts = cachedAyahs.map { ayah -> ayah.english }

            SurahDetail(
                surahNo = cachedSurah.surahNo,
                arabic1 = arabicTexts,
                english = englishTexts,
                surahName = cachedSurah.surahName,
                surahNameTranslation = cachedSurah.surahNameTranslation
            )
        }
    }

    override suspend fun getSurahDtoById(surahId: String): SurahDetailDto {
        return api.getSurahById(surahId)
    }


    override suspend fun cacheSurah(surah: SurahEntity, ayah: List<AyahEntity>) {
        dao.cacheSurah(surah, ayah)
    }


}