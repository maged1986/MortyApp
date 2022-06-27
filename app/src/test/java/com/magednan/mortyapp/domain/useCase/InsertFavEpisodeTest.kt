package com.magednan.mortyapp.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.magednan.mortyapp.MainCoroutineRule
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.repository.FakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InsertFavEpisodeTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var insertFavEpisode: InsertFavEpisode
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
        insertFavEpisode= InsertFavEpisode(repository)
        runBlocking {
            repository.insertFavEpisode(episodeEntity)}
    }


    @Test
    fun assertNotNull() {
        assertNotNull(episodeEntity)
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            Truth.assertThat(repository.getAllFavEpisodes()).contains(episodeEntity)
        }
    }
}