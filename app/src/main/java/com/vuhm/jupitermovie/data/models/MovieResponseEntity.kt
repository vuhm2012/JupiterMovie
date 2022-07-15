package com.vuhm.jupitermovie.data.models

import com.google.gson.annotations.SerializedName

data class MovieResponseEntity(
    @field:SerializedName("page") val page: Int,
    @field:SerializedName("results") val results: List<MovieEntity>,
    @field:SerializedName("total_pages") val totalPages: Int,
    @field:SerializedName("total_results") val totalResults: Int,
)
