package com.vuhm.jupitermovie.domain.use_cases

import com.vuhm.jupitermovie.base.BaseUseCase
import com.vuhm.jupitermovie.core.utils.Resource
import com.vuhm.jupitermovie.domain.models.MovieResponse
import com.vuhm.jupitermovie.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTrendingUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseUseCase<Unit, MovieResponse>() {
    override suspend fun invoke(params: Unit): Flow<Resource<MovieResponse>> = flow {
        try {
            emit(Resource.Loading())
            val trending = movieRepository.getTrending()
            emit(Resource.Success(trending))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "HTTP Exception"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "IO Exception"))
        }
    }
}