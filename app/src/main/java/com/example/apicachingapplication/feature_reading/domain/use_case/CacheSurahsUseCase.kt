package com.example.apicachingapplication.feature_reading.domain.use_case

import android.util.Log
import com.example.apicachingapplication.core.Resource
import javax.inject.Inject

class CacheSurahsUseCase @Inject constructor(
    private val cacheSurahCase: CacheSurahUseCase
){
    suspend operator fun invoke() {
        for (surahNumber in 1..114) {
            cacheSurahCase(surahId = surahNumber.toString()).collect { result ->
                when(result) {
                    is Resource.Success -> {
                        Log.d("AllSurahsCached", "Surah $surahNumber Cached")
                    }
                    is Resource.Error -> {
                        Log.d("AllSurahsCached", "Surah $surahNumber Failed to Cache")
                    }
                    is Resource.Loading -> {
                        Log.d("AllSurahsCached", "Loading $surahNumber cache status")
                    }
                }

            }
        }
    }
}






