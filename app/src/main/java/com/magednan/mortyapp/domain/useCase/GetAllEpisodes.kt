package com.magednan.mortyapp.domain.useCase

import com.magednan.mortyapp.data.dtos.episode.EpisodeResponse
import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetAllEpisodes  (  val repository: Repository) {
    suspend operator fun invoke(): Flow<Resource<EpisodeResponse>> {
        return repository.getAllEpisodes()
    }
}