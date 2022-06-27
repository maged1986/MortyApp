package com.magednan.mortyapp.data.remote

import com.magednan.mortyapp.data.dtos.character.CharactersResponse
import com.magednan.mortyapp.data.dtos.episode.EpisodeResponse
import com.magednan.mortyapp.data.dtos.location.LocationResponse
import retrofit2.Response
import retrofit2.http.GET

interface MortyApi {

    @GET("character?page=2")
    suspend fun getAllCharacters(): Response<CharactersResponse>
    @GET("location")
    suspend fun getAllLocations(): Response<LocationResponse>
    @GET("episode")
    suspend fun getAllEpisodes(): Response<EpisodeResponse>
}