package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface SurahDao {

    @Query("SELECT * FROM SurahListEntity WHERE id = :id")
    suspend fun getSurahDetail(id: Int): SurahEntity

}