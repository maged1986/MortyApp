package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.dtos.location.LocationResponse
import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class  GetAllLocations( val repository: Repository) {
    suspend operator fun invoke(): Flow<Resource<LocationResponse>> {
        return repository.getAllLocations()
    }
}