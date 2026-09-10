package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.Surah
import com.example.apicachingapplication.feature_reading.domain.model.SurahEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuranDao {
    @Upsert
    suspend fun cacheSurah(surah: SurahEntity, ayahs: List<AyahEntity>)

    @Query("SELECT * FROM SurahEntity ORDER BY surahNo ASC")
    fun getAllSurahs(): Flow<List<SurahEntity>>

    @Upsert
    suspend fun cacheSurahList(surahs: List<SurahEntity>)

    @Query("SELECT * FROM SurahEntity WHERE surahNo = :surahId ")
    suspend fun getSurahEntityById(surahId: Int): SurahEntity?


    @Query("SELECT * FROM AyahEntity WHERE surahNo = :surahId ORDER BY ayahNo ASC")
    suspend fun getAyahEntityById(surahId: Int): List<AyahEntity>
}