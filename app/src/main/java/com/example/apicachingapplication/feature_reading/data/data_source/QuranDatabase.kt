package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SurahListEntity::class, SurahEntity::class],
    version = 1
)

abstract class QuranDatabase: RoomDatabase() {

    abstract val dao: SurahDao

    companion object {
        const val DATABASE_NAME = "quran_db"
    }
}