package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Dao
import androidx.room.Upsert
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail

@Dao
interface QuranDao {

    @Upsert
    suspend fun upsertTask(task: SurahDetail)

}