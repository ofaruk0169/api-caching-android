package com.example.apicachingapplication.di

import com.example.apicachingapplication.core.Constants
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
    fun provideSurahRepository(api: QuranPagesApi): SurahRepository {
        return SurahRepositoryImpl(api)
    }
}