package com.vuhm.jupitermovie.base

import com.vuhm.jupitermovie.core.utils.Resource
import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<in Params, out Type> {

    abstract suspend operator fun invoke(params: Params): Flow<Resource<out Type>>

}