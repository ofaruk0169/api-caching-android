package com.example.apicachingapplication.feature_reading.domain.repository

import com.example.apicachingapplication.feature_reading.domain.model.Contributor
import com.example.apicachingapplication.feature_reading.domain.model.Surah

interface ContributorRepository {

    suspend fun getContributors(): List<Contributor>
}