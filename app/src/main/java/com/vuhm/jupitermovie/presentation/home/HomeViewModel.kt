package com.vuhm.jupitermovie.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vuhm.jupitermovie.core.utils.Resource
import com.vuhm.jupitermovie.domain.models.MovieResponse
import com.vuhm.jupitermovie.domain.use_cases.GetTrendingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTrendingUseCase: GetTrendingUseCase
) : ViewModel() {

    private val _data =
        MutableStateFlow<Resource<MovieResponse>>(Resource.Error(null, "Errorrrrrrr"))
    val data = _data.asStateFlow()

    fun getTrending() {
        viewModelScope.launch {
            getTrendingUseCase(Unit).collect {
                _data.value = it
            }
        }
    }
}