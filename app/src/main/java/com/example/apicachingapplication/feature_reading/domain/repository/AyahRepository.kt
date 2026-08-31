package com.example.apicachingapplication.feature_reading.domain.repository

import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity

interface AyahRepository {


    suspend fun getAyah(): AyahEntity

    suspend fun getAyahById(surahId: Int, ayahId: Int): AyahEntity

}