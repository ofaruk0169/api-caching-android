package com.example.apicachingapplication.feature_reading.domain.use_case

import com.example.apicachingapplication.core.Resource
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurah
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurahDetail
import com.example.apicachingapplication.feature_reading.domain.model.Surah
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSurahUseCase @Inject constructor(
    private val repository: SurahRepository
) {
    operator fun invoke(surahId: String): Flow<Resource<SurahDetail>> = flow {
        try {
            emit(Resource.Loading<SurahDetail>())
            val surah = repository.getSurahById(surahId).toSurahDetail()
            emit(Resource.Success<SurahDetail>(surah))
        } catch (e: HttpException) {
            emit(Resource.Error<SurahDetail>(e.localizedMessage ?: "An unexpected  error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<SurahDetail>("Couldn't reach server. Please check connection."))
        }
    }

}