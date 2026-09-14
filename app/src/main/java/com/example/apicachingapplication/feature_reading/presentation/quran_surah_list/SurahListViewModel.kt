package com.example.apicachingapplication.feature_reading.presentation.quran_surah_list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.apicachingapplication.core.Resource
import com.example.apicachingapplication.feature_reading.domain.use_case.CacheSurahsUseCase
import com.example.apicachingapplication.feature_reading.domain.use_case.GetSurahsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@HiltViewModel
class SurahListViewModel @Inject constructor(
    private val getSurahsUseCase: GetSurahsUseCase,
    private val cacheAllSurahsUseCase: CacheSurahsUseCase

) : ViewModel() {
    private val _state = mutableStateOf<SurahListState>(SurahListState())
    val state: State<SurahListState> = _state

    fun getSurahs() {
        getSurahsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = SurahListState(surahs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = SurahListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = SurahListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun cacheAllSurahs() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isCacheAllLoading = true)
            cacheAllSurahsUseCase()
            _state.value = _state.value.copy(isCacheAllLoading = false)
            getSurahs()

        }
    }

}

