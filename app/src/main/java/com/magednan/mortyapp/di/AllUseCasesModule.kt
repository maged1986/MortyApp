package com.magednan.mortyapp.di

import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.domain.useCase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AllUseCasesModule {

    @Provides
    @Singleton
    fun provideAllCases(repository: Repository): AllUseCases {
        return AllUseCases(
            getAllCharacters = GetAllCharacters(repository),
            getAllEpisodes = GetAllEpisodes(repository),
            getAllLocations = GetAllLocations(repository),
            getAllFavCharacters = GetAllFavCharacters(repository),
            insertAFavCharacter = InsertAFavCharacter(repository),
            deleteFavCharacter = DeleteFavCharacter(repository),
            insertLocation = InsertLocation(repository),
            getAllFavLocations = GetAllFavLocations(repository),
            deleteLocation = DeleteFavLocation(repository),
            insertFavEpisode = InsertFavEpisode(repository),
            getAllFavEpisode = GetAllFavEpisode(repository),
            deleteFavEpisode = InsertFavEpisode(repository),
            getCharacters = GetCharacters(repository),
            getEpisodes = GetEpisodes(repository),
            getLocations = GetLocations(repository),
        )
    }
}