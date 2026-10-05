package com.example.apicachingapplication.feature_reading.presentation.quran_contributors

import androidx.lifecycle.SavedStateHandle
import com.example.apicachingapplication.feature_reading.domain.use_case.GetContributorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContributorViewModel @Inject constructor(
    private val getContributorUseCase: GetContributorUseCase,
    savedStateHandle: SavedStateHandle
) {
}