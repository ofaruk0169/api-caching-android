package com.example.apicachingapplication.feature_reading.presentation.quran_reader

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicachingapplication.core.Constants
import com.example.apicachingapplication.core.Resource
import com.example.apicachingapplication.feature_reading.domain.use_case.CacheSurahUseCase
import com.example.apicachingapplication.feature_reading.domain.use_case.GetSurahUseCase
import com.example.apicachingapplication.feature_reading.domain.use_case.GetSurahsUseCase
import com.example.apicachingapplication.feature_reading.presentation.quran_surah_list.SurahListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SurahDetailViewModel @Inject constructor(
    private val getSurahUseCase: GetSurahUseCase,
    private val cacheSurahUseCase: CacheSurahUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(SurahDetailState())
    val state: State<SurahDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { surahId ->
            getSurah(surahId)
        }
    }

    private fun getSurah(surahId: String) {
        getSurahUseCase(surahId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = SurahDetailState(surah = result.data)
                }
                is Resource.Error -> {
                    _state.value = SurahDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = SurahDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}