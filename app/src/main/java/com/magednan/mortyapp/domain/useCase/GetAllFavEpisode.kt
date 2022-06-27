package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.EpisodeEntity
import com.magednan.mortyapp.domain.repository.Repository

class GetAllFavEpisode (val repository: Repository) {

    suspend operator fun invoke(): List<EpisodeEntity> {
        return repository.getAllFavEpisodes()
    }
}