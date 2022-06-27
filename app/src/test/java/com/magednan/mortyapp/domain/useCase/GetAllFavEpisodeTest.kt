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

class GetAllFavEpisodeTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var getAllFavEpisode: GetAllFavEpisode
    val repository = FakeRepository()

    @Before
    fun setup() {
        getAllFavEpisode= GetAllFavEpisode(repository)
    }

    @Test
    fun assertNotNull() {
        runBlocking {
        assertNotNull(getAllFavEpisode.invoke())}
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            Truth.assertThat(getAllFavEpisode.invoke())
                .isEqualTo(repository.episodeEntities)}

    }

}