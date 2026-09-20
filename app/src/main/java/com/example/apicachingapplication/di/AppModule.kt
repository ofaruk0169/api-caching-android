package com.example.apicachingapplication.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import androidx.datastore.preferences.preferencesDataStore
import com.example.apicachingapplication.core.Constants
import com.example.apicachingapplication.feature_reading.data.data_source.QuranDatabase
import com.example.apicachingapplication.feature_reading.data.remote.QuranPagesApi
import com.example.apicachingapplication.feature_reading.data.repository.SurahRepositoryImpl
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import com.example.apicachingapplication.feature_reading.domain.repository.TextSizeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "user_preferences")


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
            //remember to remove fallback in production.
        ).fallbackToDestructiveMigration().build()
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

    // datastore


    @Provides
    @Singleton
    fun provideDataStore(app: Application): DataStore<Preferences> {
        return app.dataStore
    }

    @Provides
    @Singleton
    fun provideUserPreferencesRepository (dataStore: DataStore<Preferences>): TextSizeRepository {
        return TextSizeRepositoryImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideUserPreferencesUseCases(repository: UserPreferencesRepository): PreferencesUseCases {
        return PreferencesUseCases(
            increaseSp = IncreaseSp(repository),
            decreaseSp = DescreaseSp(repository)
        )
    }
}