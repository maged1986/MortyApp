package com.magednan.mortyapp.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.magednan.mortyapp.MainCoroutineRule
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.repository.FakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InsertLocationTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var insertFavLocations: InsertLocation
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
        insertFavLocations= InsertLocation(repository)
        runBlocking {
            repository.insertFavLocation(locationEntity)}
    }


    @Test
    fun assertNotNull() {
        assertNotNull(locationEntity)
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            Truth.assertThat(repository.getAllFavLocations()).contains(locationEntity)
        }
    }
}