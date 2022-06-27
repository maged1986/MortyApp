package com.magednan.mortyapp.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.magednan.mortyapp.MainCoroutineRule
import com.magednan.mortyapp.repository.FakeRepository
import com.magednan.mortyapp.utils.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetAllEpisodesTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var getAllEpisodes: GetAllEpisodes
    val repository = FakeRepository()
    val successState=  Resource.Success(data = repository.episodeResponse)
    val errorSate=  Resource.Error(errorMessage  = "Here is an error ")
    val loadingState=  Resource.Loading


    @Before
    fun setup() {
        getAllEpisodes = GetAllEpisodes(repository)
    }

    @Test
    fun assertNotNull() {
        assertNotNull(repository.episodeEntities)
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            repository.getAllEpisodes().collect{
                Truth.assertThat(it).isEqualTo(successState)
            }
        }
    }

    @Test
    fun makeItFails() {
        runBlocking {
            repository.getAllEpisodes().collect{
                Truth.assertThat(it).isNotEqualTo(errorSate)
                Truth.assertThat(it).isNotEqualTo(loadingState)
            }}
    }
}