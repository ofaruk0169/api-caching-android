package com.example.apicachingapplication.feature_reading.domain.use_case

import com.example.apicachingapplication.core.Resource
import com.example.apicachingapplication.feature_reading.data.remote.dto.toAyahEntities
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurahDetail
import com.example.apicachingapplication.feature_reading.data.remote.dto.toSurahEntity
import com.example.apicachingapplication.feature_reading.domain.model.AyahEntity
import com.example.apicachingapplication.feature_reading.domain.model.SurahDetail
import com.example.apicachingapplication.feature_reading.domain.repository.AyahRepository
import com.example.apicachingapplication.feature_reading.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CacheSurahUseCase (
    private val repository: SurahRepository
)  {
    operator fun invoke(surahId: String): Flow<Resource<List<AyahEntity>>> = flow {
        try {
            emit(Resource.Loading<List<AyahEntity>>())
            val surahAyah = repository.getSurahById(surahId).toAyahEntities()
            val surah = repository.getSurahById(surahId).toSurahEntity()

            val dto = repository.getSurahById(surahId)
            val sur


            emit(Resource.Success<List<AyahEntity>>(surahAyah))
        } catch (e: HttpException) {
            emit(Resource.Error<List<AyahEntity>>(e.localizedMessage ?: "An unexpected  error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<AyahEntity>>("Couldn't reach server. Please check connection."))
        }
    }
}