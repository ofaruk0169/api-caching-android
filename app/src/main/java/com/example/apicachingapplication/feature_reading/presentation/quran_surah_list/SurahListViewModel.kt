package com.example.apicachingapplication.feature_reading.presentation.quran_surah_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.apicachingapplication.feature_reading.domain.use_case.GetSurahUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State


@HiltViewModel
class SurahListViewModel @Inject constructor(
    private val getSurahUseCase: GetSurahUseCase
) : ViewModel() {


    private val _state = mutableStateOf<SurahListState>(SurahListState())
    val state: State<SurahListState> = _state
}