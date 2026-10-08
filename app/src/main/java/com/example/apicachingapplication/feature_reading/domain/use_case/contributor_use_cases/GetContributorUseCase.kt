package com.example.apicachingapplication.feature_reading.domain.use_case.contributor_use_cases

import com.example.apicachingapplication.feature_reading.domain.repository.ContributorRepository
import javax.inject.Inject

class GetContributorUseCase @Inject constructor(
    private val repository: ContributorRepository
) {

}