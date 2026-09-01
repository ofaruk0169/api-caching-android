package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Dao
import androidx.room.Upsert
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail
import com.example.apicachingapplication.feature_reading.domain.model.SurahEntity

@Dao
interface QuranDao {
    @Upsert
    suspend fun upsertSurah(surah: SurahEntity)

    @Upsert
    suspend fun upsertAyahs(ayahs: List<AyahEntity>)

}