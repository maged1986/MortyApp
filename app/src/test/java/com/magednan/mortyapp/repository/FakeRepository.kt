package com.magednan.mortyapp.repository

import com.magednan.mortyapp.data.dtos.character.CharacterDto
import com.magednan.mortyapp.data.dtos.character.CharactersResponse
import com.magednan.mortyapp.data.dtos.character.Info
import com.magednan.mortyapp.data.dtos.episode.EpisodeDto
import com.magednan.mortyapp.data.dtos.episode.EpisodeResponse
import com.magednan.mortyapp.data.dtos.location.LocationDto
import com.magednan.mortyapp.data.dtos.location.LocationResponse
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.EpisodeEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.models.Location
import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Before

class FakeRepository : Repository {
    val characters = ArrayList<Character>()
    val characterDtos = ArrayList<CharacterDto>()
    val characterEntities = ArrayList<CharacterEntity>()
    val charactersResponse = CharactersResponse(Info(0, "", 0, ""), characterDtos)
    val episodes = ArrayList<Episode>()
    val episodeEntities = ArrayList<EpisodeEntity>()
    val episodeDtos = ArrayList<EpisodeDto>()
    val episodeResponse =
        EpisodeResponse(com.magednan.mortyapp.data.dtos.episode.Info(0, "", 0, ""), episodeDtos)
    val locations = ArrayList<Location>()
    val locationDtos = ArrayList<LocationDto>()
    val locationEntities = ArrayList<LocationEntity>()
    val locationResponse =
        LocationResponse(com.magednan.mortyapp.data.dtos.location.Info(0, "", 0, ""), locationDtos)

    @Before
    fun setup() {

        characters.add(Character(1, "", emptyList(), "", "", "", "", "", "", ""))
        characters.add(Character(1, "", emptyList(), "", "", "", "", "", "", ""))
        characters.add(Character(1, "", emptyList(), "", "", "", "", "", "", ""))

        characterDtos.add(CharacterDto("", emptyList(), "", 0, "", null, "", null, "", "", "", ""))
        characterDtos.add(CharacterDto("", emptyList(), "", 0, "", null, "", null, "", "", "", ""))
        characterDtos.add(CharacterDto("", emptyList(), "", 0, "", null, "", null, "", "", "", ""))

        characterEntities.add(CharacterEntity(1, "", emptyList(), "", "", "", "", "", "", ""))
        characterEntities.add(CharacterEntity(1, "", emptyList(), "", "", "", "", "", "", ""))
        characterEntities.add(CharacterEntity(1, "", emptyList(), "", "", "", "", "", "", ""))

        episodes.add(Episode("", emptyList(), "", "", 0, "", ""))
        episodes.add(Episode("", emptyList(), "", "", 0, "", ""))
        episodes.add(Episode("", emptyList(), "", "", 0, "", ""))
        episodeEntities.add(EpisodeEntity("", emptyList(), "", "", 0, "", ""))
        episodeEntities.add(EpisodeEntity("", emptyList(), "", "", 0, "", ""))
        episodeEntities.add(EpisodeEntity("", emptyList(), "", "", 0, "", ""))

        locations.add(Location("", "", 0, "", emptyList(), "", ""))
        locations.add(Location("", "", 0, "", emptyList(), "", ""))
        locations.add(Location("", "", 0, "", emptyList(), "", ""))

        locationEntities.add(LocationEntity("", "", 0, "", emptyList(), "", ""))
        locationEntities.add(LocationEntity("", "", 0, "", emptyList(), "", ""))
        locationEntities.add(LocationEntity("", "", 0, "", emptyList(), "", ""))

    }

    override suspend fun getAllCharacters(): Flow<Resource<CharactersResponse>> {
        return flow { emit(Resource.Success(data = charactersResponse)) }
    }

    override suspend fun getAllLocations(): Flow<Resource<LocationResponse>> {
        return flow { emit(Resource.Success(data = locationResponse)) }
    }

    override suspend fun getAllEpisodes(): Flow<Resource<EpisodeResponse>> {
        return flow { emit(Resource.Success(data = episodeResponse)) }
    }

    override suspend fun insert(characterEntity: CharacterEntity) {
        characterEntities.add(characterEntity)
    }

    override suspend fun getAllFavCharacters(): List<CharacterEntity> {
        return characterEntities
    }

    override suspend fun deleteFavCharacter(characterEntity: CharacterEntity) {
        characterEntities.remove(characterEntity)
    }

    override suspend fun insertFavEpisode(episodeEntity: EpisodeEntity) {
        episodeEntities.add(episodeEntity)
    }

    override suspend fun getAllFavEpisodes(): List<EpisodeEntity> {
        return episodeEntities
    }

    override suspend fun deleteFavEpisode(episodeEntity: EpisodeEntity) {
        episodeEntities.remove(episodeEntity)
    }

    override suspend fun insertFavLocation(locationEntity: LocationEntity) {
        locationEntities.add(locationEntity)
    }

    override suspend fun getAllFavLocations(): List<LocationEntity> {
        return locationEntities
    }

    override suspend fun deleteFavLocation(locationEntity: LocationEntity) {
        locationEntities.remove(locationEntity)
    }

    override suspend fun getLocations(list: List<String>): Flow<Resource<List<Location>>> {
        return flow { emit(Resource.Success(data = locations)) }
    }

    override suspend fun getCharacters(list: List<String>): Flow<Resource<List<Character>>> {
        return flow { emit(Resource.Success(data = characters)) }
    }

    override suspend fun getEpisodes(list: List<String>): Flow<Resource<List<Episode>>> {
        return flow {
            emit(Resource.Success(data = episodes))
        }
    }


}