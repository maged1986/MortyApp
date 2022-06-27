package com.magednan.mortyapp.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.magednan.mortyapp.MainCoroutineRule
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.repository.FakeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
@ExperimentalCoroutinesApi
class DeleteFavLocationTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var deleteFavLocation: DeleteFavLocation
    val repository = FakeRepository()
    val locationEntity = LocationEntity(
        "bnnb",
        "nbnbnb",
        144,
        "nmnm",
        emptyList(),
        "nmnm",
        "nmnm",

    )

    @Before
    fun setup() {
        deleteFavLocation = DeleteFavLocation(repository)
        runBlocking {
            repository.insertFavLocation(locationEntity)}
    }


    @Test
    fun assertNotNull() {
        assertNotNull(repository.locationEntities)
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            repository.deleteFavLocation(locationEntity)
            Truth.assertThat(repository.getAllFavLocations()).doesNotContain(locationEntity)
        }
    }
   @Test
    fun makeItFails() {
        runBlocking {
            repository.deleteFavLocation(locationEntity)
            Truth.assertThat(repository.getAllFavCharacters()).contains(locationEntity)
        }
    }

}