package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.domain.repository.Repository

class InsertLocation(val repository: Repository) {

    suspend operator fun invoke(locationEntity: LocationEntity){
        repository.insertFavLocation(locationEntity)}
}