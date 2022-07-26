package com.vuhm.jupitermovie.presentation.home

import androidx.lifecycle.ViewModel
import com.vuhm.jupitermovie.core.utils.Resource
import com.vuhm.jupitermovie.domain.models.MovieResponse
import com.vuhm.jupitermovie.domain.use_cases.GetTrendingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTrendingUseCase: GetTrendingUseCase
) : ViewModel() {

    private val _data = MutableStateFlow(emptyFlow<Resource<MovieResponse>>())
    val data = _data.asStateFlow()

    fun getTrending() {

    }
}