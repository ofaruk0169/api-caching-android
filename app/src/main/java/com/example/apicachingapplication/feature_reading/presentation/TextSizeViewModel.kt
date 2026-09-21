package com.example.apicachingapplication.feature_reading.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicachingapplication.feature_reading.domain.use_case.text_use_case.TextSizeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TextSizeViewModel @Inject constructor(
    private val textSizeUseCases: TextSizeUseCases
) : ViewModel() {
    private val _textsize = mutableStateOf(TextSizeState())
    val textsize: State<TextSizeState> = _textsize

    init {
        viewModelScope.launch {
            textSizeUseCases.getTextSize().collect {
                option -> _textsize.value = _textsize.value.copy(textSize = option)
            }
        }
    }


    fun increaseTextSize() {
        viewModelScope.launch {
            textSizeUseCases.increaseTextSize()
        }
    }

    fun decreaseTextSize() {
        viewModelScope.launch {
            textSizeUseCases.decreaseTextSize()
        }
    }
}