package com.vuhm.jupitermovie.domain.repositories

import com.vuhm.jupitermovie.domain.models.MovieResponse

interface MovieRepository {
    suspend fun getTrending(): MovieResponse
}