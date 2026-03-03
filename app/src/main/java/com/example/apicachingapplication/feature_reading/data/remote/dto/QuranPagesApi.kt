package com.example.apicachingapplication.feature_reading.data.remote.dto

import retrofit2.http.GET

interface QuranPagesApi {


    //2 function, get all Surahs, and to get a specific Surah based on that Surah's ID.

    @GET("/api/surah.json")
    suspend fun getSurahs()
}