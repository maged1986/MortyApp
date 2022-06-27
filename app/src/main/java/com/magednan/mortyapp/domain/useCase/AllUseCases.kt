package com.magednan.mortyapp.domain.useCase

data class AllUseCases(
    val getAllCharacters:GetAllCharacters,
    val getAllEpisodes: GetAllEpisodes,
    val getAllLocations: GetAllLocations,
    val getAllFavCharacters: GetAllFavCharacters,
    val insertAFavCharacter: InsertAFavCharacter,
    val deleteFavCharacter: DeleteFavCharacter,
    val insertLocation: InsertLocation,
    val getAllFavLocations: GetAllFavLocations,
    val deleteLocation: DeleteFavLocation ,
    val insertFavEpisode: InsertFavEpisode,
    val getAllFavEpisode: GetAllFavEpisode,
    val deleteFavEpisode: InsertFavEpisode,
    val getCharacters:GetCharacters,
    val getEpisodes: GetEpisodes,
    val getLocations: GetLocations,


)
