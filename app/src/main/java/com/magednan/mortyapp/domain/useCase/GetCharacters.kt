package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Location
import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetCharacters ( val repository: Repository){
    suspend operator fun invoke (list: List<String>): Flow<Resource<List<Character>>> {
        return repository.getCharacters(list)
    }
}