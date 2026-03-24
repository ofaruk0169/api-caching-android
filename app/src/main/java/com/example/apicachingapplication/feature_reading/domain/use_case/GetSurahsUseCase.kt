package com.example.apicachingapplication.feature_reading.domain.use_case

import com.example.apicachingapplication.core.Resource
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurah
import com.example.apicachingapplication.feature_reading.domain.model.Surah
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSurahsUseCase @Inject constructor(
    private val repository: SurahRepository
) {
    operator fun invoke(): Flow<Resource<List<Surah>>> = flow {
        try {
            emit(Resource.Loading<List<Surah>>())
            val surahs = repository.getSurahs().mapIndexed { index, item ->
                item.toSurah(index + 1)
            }
            emit(Resource.Success<List<Surah>>(surahs))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Surah>>(e.localizedMessage ?: "An unexpected  error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Surah>>("Couldn't reach server. Please check connection."))
        }
    }

}