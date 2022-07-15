package com.vuhm.jupitermovie.data.mappers

import com.vuhm.jupitermovie.data.models.MovieResponseEntity
import com.vuhm.jupitermovie.domain.models.MovieResponse

class MovieResponseMapper : EntityMapper<MovieResponseEntity, MovieResponse> {

    lateinit var movieMapper: MovieMapper

    override fun mapFromEntity(entity: MovieResponseEntity): MovieResponse {
        return MovieResponse(
            page = entity.page,
            results = movieMapper.mapFromEntityList(entity.results),
            totalPages = entity.totalPages,
            totalResults = entity.totalResults,
        )
    }

    override fun mapToEntity(domainModel: MovieResponse): MovieResponseEntity {
        return MovieResponseEntity(
            page = domainModel.page,
            results = movieMapper.mapToEntityList(domainModel.results),
            totalPages = domainModel.totalPages,
            totalResults = domainModel.totalResults,
        )
    }

    override fun mapFromEntityList(list: List<MovieResponseEntity>): List<MovieResponse> =
        list.map {
            mapFromEntity(it)
        }

    override fun mapToEntityList(list: List<MovieResponse>): List<MovieResponseEntity> = list.map {
        mapToEntity(it)
    }
}