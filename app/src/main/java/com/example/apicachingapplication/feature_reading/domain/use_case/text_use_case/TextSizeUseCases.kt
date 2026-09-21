package com.example.apicachingapplication.feature_reading.domain.use_case.text_use_case

data class TextSizeUseCases(
    val increaseTextSize: IncreaseTextSizeUseCase,
    val decreaseTextSize: DecreaseTextSizeUseCase,
    val getTextSize: GetTextSizeUseCase
)