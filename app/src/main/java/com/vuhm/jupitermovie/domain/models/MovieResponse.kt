package com.vuhm.jupitermovie.domain.models

import com.vuhm.jupitermovie.data.models.MovieEntity

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int,
)
