package com.vuhm.jupitermovie.data.repositories_impl

import com.vuhm.jupitermovie.data.data_sources.remote.MovieAPI
import com.vuhm.jupitermovie.data.mappers.MovieResponseMapper
import com.vuhm.jupitermovie.domain.models.MovieResponse
import com.vuhm.jupitermovie.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl : MovieRepository {

    @Inject
    lateinit var movieApi: MovieAPI

    @Inject
    lateinit var movieResponseMapper: MovieResponseMapper

    override suspend fun getTrending(): MovieResponse {
        return movieResponseMapper.mapFromEntity(movieApi.getTrending())
    }
}