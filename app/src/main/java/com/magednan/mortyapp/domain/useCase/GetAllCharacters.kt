package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.dtos.character.CharactersResponse
import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetAllCharacters (
    val repository: Repository
) {
    suspend operator fun invoke(): Flow<Resource<CharactersResponse>> {
        return repository.getAllCharacters()
    }

}