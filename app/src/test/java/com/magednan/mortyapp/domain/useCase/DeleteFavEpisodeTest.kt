package com.magednan.mortyapp.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.magednan.mortyapp.MainCoroutineRule
import com.magednan.mortyapp.repository.FakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DeleteFavEpisodeTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var deleteFavEpisode: DeleteFavEpisode
    val repository = FakeRepository()
    val episodeEntity = com.magednan.mortyapp.data.local.entities.EpisodeEntity(
        "nbnbnb",
        emptyList(),
        "m,m,",
        "nmnm",
        12,
        "nmnm",
        "nmnm",
    )

    @Before
    fun setup() {
        deleteFavEpisode = DeleteFavEpisode(repository)
        runBlocking {
            repository.insertFavEpisode(episodeEntity)}
    }


    @Test
    fun assertNotNull() {
        assertNotNull(repository.episodeEntities)
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            repository.deleteFavEpisode(episodeEntity)
            Truth.assertThat(repository.getAllFavCharacters()).doesNotContain(episodeEntity)
        }
    }
   @Test
    fun makeItFails() {
        runBlocking {
            repository.deleteFavEpisode(episodeEntity)
            Truth.assertThat(repository.getAllFavCharacters()).contains(episodeEntity)
        }
    }

}