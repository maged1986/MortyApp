package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.domain.repository.Repository

class GetAllFavLocations(val repository: Repository) {

    suspend operator fun invoke(): List<LocationEntity> {
        return repository.getAllFavLocations()
    }
}