package com.magednan.mortyapp.data.repositoryImpl

import android.util.Log
import androidx.compose.foundation.layout.R
import androidx.compose.runtime.rememberCoroutineScope
import com.beust.klaxon.Klaxon
import com.magednan.mortyapp.data.dtos.character.CharacterDto
import com.magednan.mortyapp.data.dtos.character.CharactersResponse
import com.magednan.mortyapp.data.dtos.episode.EpisodeDto
import com.magednan.mortyapp.data.dtos.episode.EpisodeResponse
import com.magednan.mortyapp.data.dtos.location.LocationResponse
import com.magednan.mortyapp.data.local.CharacterDao
import com.magednan.mortyapp.data.local.EpisodeDao
import com.magednan.mortyapp.data.local.LocationDao
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.EpisodeEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.data.mapper.toCharacter
import com.magednan.mortyapp.data.remote.MortyApi
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.models.Location
import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.net.URL
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: MortyApi,
    private val characterDao: CharacterDao,
    private val episodeDao: EpisodeDao,
    private val locationDao: LocationDao
) : Repository {
    override suspend fun getAllCharacters(): Flow<Resource<CharactersResponse>> {
        return flow {
            //  emit(Resource.Loading)
            try {
                val response = api.getAllCharacters()
                if (response.isSuccessful && response.body() != null) {
                    emit(Resource.Success(data = response.body()!!))
                }
            } catch (e: IOException) {
                emit(Resource.Error(e.message.toString()))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }


    override suspend fun getAllLocations(): Flow<Resource<LocationResponse>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = api.getAllLocations()
                if (response.isSuccessful && response.body() != null) {
                    emit(Resource.Success(response.body()!!))
                }
            } catch (e: IOException) {
                emit(Resource.Error(e.message.toString()))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }


    override suspend fun getAllEpisodes(): Flow<Resource<EpisodeResponse>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = api.getAllEpisodes()
                if (response.isSuccessful && response.body() != null) {
                    Log.d("TAG", "getAllEpisodes:${response.toString()} ")
                    emit(Resource.Success(data = response.body()!!))
                }
            }
            catch (e: IOException) {
                emit(Resource.Error(e.message.toString()))
            }
            catch (e: HttpException) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

    override suspend fun insert(characterEntity: CharacterEntity) {
        characterDao.insert(characterEntity)
    }

    override suspend fun getAllFavCharacters(): List<CharacterEntity> {
        return characterDao.getAllFavCharacters()
    }

    override suspend fun deleteFavCharacter(characterEntity: CharacterEntity) {
        characterDao.deleteFavCharacter(characterEntity)
    }

    override suspend fun insertFavEpisode(episodeEntity: EpisodeEntity) {
        episodeDao.insertFavEpisode(episodeEntity)
    }

    override suspend fun getAllFavEpisodes(): List<EpisodeEntity> {
        return episodeDao.getAllFavEpisodes()
    }

    override suspend fun deleteFavEpisode(episodeEntity: EpisodeEntity) {
        episodeDao.deleteFavEpisode(episodeEntity)
    }

    override suspend fun insertFavLocation(locationEntity: LocationEntity) {
        locationDao.insertFavLocation(locationEntity)
    }

    override suspend fun getAllFavLocations(): List<LocationEntity> {
        return locationDao.getAllFavLocations()
    }

    override suspend fun deleteFavLocation(locationEntity: LocationEntity) {
        locationDao.deleteFavLocation(locationEntity)
    }

    override suspend fun getLocations(
        list: List<String>
    ): Flow<Resource<List<Location>>> {
        return flow {
            try {
                emit(Resource.Loading)
                val characters = ArrayList<Location>()
                    if (list?.size!! >= 0) {
                        list.forEach {
                            // val url = it
                            val result = URL(it).readText()
                            val obj = Klaxon().parse<Location>(result)
                            if (obj != null) {
                                characters.add(obj)
                            }
                            //     Log.d("TAG", "CharacterRvScreen:${obj?.created} ")
                        }
                }
                emit(Resource.Success(data = characters))
            } catch (e: IOException) {
                emit(Resource.Error(errorMessage = e.message.toString()))

            }
        }

    }



    override suspend fun getEpisodes(
        list: List<String>
    ): Flow<Resource<List<Episode>>> {
        return flow {
            try {
                emit(Resource.Loading)
                if (!list.isNullOrEmpty()){
                val characters = ArrayList<Episode>()
                    for (i in list.listIterator()) {
                        val result = URL(i).readText()
                        val obj = Klaxon().parse<Episode>(result)
                            characters.add(obj!!)
                    }
                emit(Resource.Success(data = characters))
                Log.d("TAG", "CharacterRvScreen:${characters?.toString()} ")
            }} catch (e: IOException) {
                emit(Resource.Error(errorMessage = e.message.toString()))
            }
        }

    }


       override suspend fun getCharacters(
           list: List<String>
       ): Flow<Resource<List<Character>>> {
           return flow {
               try{
               emit(Resource.Loading)
               if (!list.isNullOrEmpty()){
                   val characters = ArrayList<Character>()
                   for (i in list.listIterator()) {
                               val result = URL(i).readText()
                               val obj = Klaxon().parse<CharacterDto>(result)
                       obj?.let { characters.add(it?.toCharacter()) }
                              Log.d("TAG", "getCharacters:${obj?.status} ")
                           }
                   emit(Resource.Success(data = characters))
               } }catch (e: IOException) {
                   emit(Resource.Error(errorMessage = e.message.toString()))

               }
           }
       }

}