package com.magednan.mortyapp.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magednan.mortyapp.data.dtos.character.CharactersResponse
import com.magednan.mortyapp.data.dtos.episode.EpisodeResponse
import com.magednan.mortyapp.data.dtos.location.LocationResponse
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.EpisodeEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.models.Location
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getAllCharacters(): Flow<Resource<CharactersResponse>>
    suspend fun getAllLocations(): Flow<Resource<LocationResponse>>
    suspend fun getAllEpisodes(): Flow<Resource<EpisodeResponse>>
    suspend fun insert(characterEntity: CharacterEntity)
    suspend fun getAllFavCharacters():List<CharacterEntity>
    suspend fun deleteFavCharacter(characterEntity: CharacterEntity)
    suspend fun insertFavEpisode(episodeEntity: EpisodeEntity)
    suspend fun getAllFavEpisodes():List<EpisodeEntity>
    suspend fun deleteFavEpisode(episodeEntity: EpisodeEntity)
    suspend fun insertFavLocation(locationEntity: LocationEntity)
    suspend fun getAllFavLocations():List<LocationEntity>
    suspend fun deleteFavLocation(locationEntity: LocationEntity)
    suspend fun getLocations(list:List<String>):Flow<Resource<List<Location>>>
    suspend fun getCharacters(list:List<String>):Flow<Resource<List<Character>>>
    suspend fun getEpisodes(list:List<String>):Flow<Resource<List<Episode>>>



}