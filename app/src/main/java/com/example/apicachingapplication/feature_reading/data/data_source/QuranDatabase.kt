package com.example.apicachingapplication.feature_reading.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail

@Database(
    //entities = our different tables within the database
    entities = [SurahDetail::class, AyahEntity::class],
    version = 1
)
abstract class QuranDatabase: RoomDatabase() {

    abstract val dao: QuranDao

    companion object {
        const val DATABASE_NAME = "quran_db"
    }
}
