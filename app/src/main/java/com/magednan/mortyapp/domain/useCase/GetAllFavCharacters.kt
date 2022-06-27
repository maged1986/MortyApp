package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.repositoryImpl.RepositoryImpl
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.repository.Repository

class GetAllFavCharacters(val repository: Repository) {

    suspend operator fun invoke(): List<CharacterEntity> {
        return repository.getAllFavCharacters()
    }
}