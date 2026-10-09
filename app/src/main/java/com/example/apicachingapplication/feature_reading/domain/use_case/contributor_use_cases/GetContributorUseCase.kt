package com.example.apicachingapplication.feature_reading.domain.use_case.contributor_use_cases


import com.example.apicachingapplication.feature_reading.domain.model.Contributor
import com.example.apicachingapplication.feature_reading.domain.repository.ContributorRepository

import javax.inject.Inject

class GetContributorUseCase @Inject constructor(
    private val repository: ContributorRepository
) {
   operator suspend fun invoke(contributorRole: String): Contributor?  {
        return repository.getContributors().find {it.role == contributorRole}
    }
}