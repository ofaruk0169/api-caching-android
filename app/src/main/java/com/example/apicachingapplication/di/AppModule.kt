package com.example.apicachingapplication.di

import android.app.Application
import androidx.room.Room
import com.example.apicachingapplication.core.Constants
import com.example.apicachingapplication.feature_reading.data.data_source.QuranDatabase
import com.example.apicachingapplication.feature_reading.data.remote.QuranPagesApi
import com.example.apicachingapplication.feature_reading.data.repository.SurahRepositoryImpl
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {


    //database///

    @Provides
    @Singleton
    fun provideQuranDatabase(app: Application): QuranDatabase {
        return Room.databaseBuilder(
            app,
            QuranDatabase::class.java,
            QuranDatabase.DATABASE_NAME
        ).build()
    }


    ///network ///

    @Provides
    @Singleton
    fun provideQuranPagesApi(): QuranPagesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuranPagesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSurahRepository(api: QuranPagesApi, db: QuranDatabase): SurahRepository {
        return SurahRepositoryImpl(api, db.dao)
    }

}