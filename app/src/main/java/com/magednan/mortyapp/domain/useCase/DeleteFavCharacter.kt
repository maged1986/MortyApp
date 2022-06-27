package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.domain.repository.Repository

class DeleteFavCharacter(val repository: Repository) {

    suspend operator fun invoke(characterEntity: CharacterEntity){
        repository.deleteFavCharacter(characterEntity)}
}