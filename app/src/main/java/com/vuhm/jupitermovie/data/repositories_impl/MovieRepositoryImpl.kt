package com.vuhm.jupitermovie.data.repositories_impl

import com.vuhm.jupitermovie.data.data_sources.remote.MovieAPI
import com.vuhm.jupitermovie.data.mappers.MovieResponseMapper
import com.vuhm.jupitermovie.domain.models.MovieResponse
import com.vuhm.jupitermovie.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieAPI,
    private val movieResponseMapper: MovieResponseMapper
) : MovieRepository {

    override suspend fun getTrending(): MovieResponse {
        return movieResponseMapper.mapFromEntity(movieApi.getTrending())
    }
}