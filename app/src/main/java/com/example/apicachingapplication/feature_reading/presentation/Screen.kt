package com.example.apicachingapplication.feature_reading.presentation

sealed class Screen(val route: String) {
    object SurahListScreen: Screen("surah_list_screen")
    object SurahDetailScreen: Screen("surah_detail_screen")
}