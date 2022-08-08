package com.vuhm.jupitermovie.di

import com.vuhm.jupitermovie.data.data_sources.remote.MovieAPI
import com.vuhm.jupitermovie.data.mappers.MovieMapper
import com.vuhm.jupitermovie.data.mappers.MovieResponseMapper
import com.vuhm.jupitermovie.data.repositories_impl.MovieRepositoryImpl
import com.vuhm.jupitermovie.domain.repositories.MovieRepository
import com.vuhm.jupitermovie.domain.use_cases.GetTrendingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGetTrendingUseCase(movieRepository: MovieRepository): GetTrendingUseCase =
        GetTrendingUseCase(movieRepository)

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieApi: MovieAPI,
        movieResponseMapper: MovieResponseMapper
    ): MovieRepository =
        MovieRepositoryImpl(movieApi = movieApi, movieResponseMapper = movieResponseMapper)

    @Provides
    @Singleton
    fun provideMovieAPI(): MovieAPI = MovieAPI.create()

    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper = MovieMapper()

    @Provides
    @Singleton
    fun provideMovieResponseMapper(movieMapper: MovieMapper): MovieResponseMapper =
        MovieResponseMapper(movieMapper)

}