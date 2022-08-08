package com.vuhm.jupitermovie.data.data_sources.remote

import com.vuhm.jupitermovie.data.models.MovieResponseEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface MovieAPI {

    @GET("trending/all/week?api_key=${API_KEY}")
    suspend fun getTrending(): MovieResponseEntity

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "ff19c02b4cdae6a720f195f2b3ff17ae"

        fun create(): MovieAPI = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MovieAPI::class.java)
    }
}