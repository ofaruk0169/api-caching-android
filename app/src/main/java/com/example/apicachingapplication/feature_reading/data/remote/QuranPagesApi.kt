package com.example.apicachingapplication.feature_reading.data.remote

import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDetailDto
import com.example.apicachingapplication.feature_reading.data.remote.dto.SurahDto
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranPagesApi {

    @GET("/api/surah.json")
    suspend fun getSurahs(): List<SurahDto>

    @GET("/api/{surahId}.json")
    suspend fun getSurahById(@Path("surahId") surahId: String) : SurahDetailDto
}