package com.example.apicachingapplication.feature_reading.presentation.quran_surah_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.apicachingapplication.core.Resource
import com.example.apicachingapplication.feature_reading.domain.use_case.GetSurahsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@HiltViewModel
class SurahListViewModel @Inject constructor(
    private val getSurahsUseCase: GetSurahsUseCase
) : ViewModel() {
    private val _state = mutableStateOf<SurahListState>(SurahListState())
    val state: State<SurahListState> = _state

    init {
        getSurahs()
    }

    private fun getSurahs() {
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
}