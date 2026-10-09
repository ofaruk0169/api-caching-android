package com.example.apicachingapplication.feature_reading.presentation.quran_contributors

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.apicachingapplication.core.Constants
import com.example.apicachingapplication.feature_reading.domain.model.Contributor
import com.example.apicachingapplication.feature_reading.domain.use_case.GetContributorUseCase
import com.example.apicachingapplication.feature_reading.presentation.quran_reader.SurahDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContributorViewModel @Inject constructor(
    private val getContributorUseCase: GetContributorUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<Contributor?>(null)


    private val contributorRole: String? = savedStateHandle.get<String>(Constants.PARAM_CONTRIBUTOR_ROLE)


}

//read claude tomorrow and figure it out.