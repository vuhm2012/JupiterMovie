package com.vuhm.jupitermovie.data.mappers

import com.vuhm.jupitermovie.data.models.MovieEntity
import com.vuhm.jupitermovie.domain.models.Movie

class MovieMapper : EntityMapper<MovieEntity, Movie> {

    override fun mapFromEntity(entity: MovieEntity): Movie {
        return Movie(
            posterPath = entity.posterPath,
            adult = entity.adult,
            overview = entity.overview,
            releaseDate = entity.releaseDate,
            genreIds = entity.genreIds,
            id = entity.id,
            originalTitle = entity.originalTitle,
            originalLanguage = entity.originalLanguage,
            title = entity.title,
            backdropPath = entity.backdropPath,
            popularity = entity.popularity,
            voteCount = entity.voteCount,
            video = entity.video,
            voteAverage = entity.voteAverage
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieEntity {
        return MovieEntity(
            posterPath = domainModel.posterPath,
            adult = domainModel.adult,
            overview = domainModel.overview,
            releaseDate = domainModel.releaseDate,
            genreIds = domainModel.genreIds,
            id = domainModel.id,
            originalTitle = domainModel.originalTitle,
            originalLanguage = domainModel.originalLanguage,
            title = domainModel.title,
            backdropPath = domainModel.backdropPath,
            popularity = domainModel.popularity,
            voteCount = domainModel.voteCount,
            video = domainModel.video,
            voteAverage = domainModel.voteAverage
        )
    }

    override fun mapFromEntityList(list: List<MovieEntity>): List<Movie> = list.map {
        mapFromEntity(it)
    }

    override fun mapToEntityList(list: List<Movie>): List<MovieEntity> = list.map {
        mapToEntity(it)
    }
}