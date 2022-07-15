package com.vuhm.jupitermovie.di

import com.vuhm.jupitermovie.data.data_sources.remote.MovieAPI
import com.vuhm.jupitermovie.data.mappers.MovieMapper
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
    fun provideMovieAPI() = MovieAPI.create()

    @Provides
    @Singleton
    fun provideMovieMapper() = MovieMapper()

}