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

class GetAllFavLocationsTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var getAllFavLocations: GetAllFavLocations
    val repository = FakeRepository()

    @Before
    fun setup() {
        getAllFavLocations= GetAllFavLocations(repository)
    }

    @Test
    fun assertNotNull() {
        runBlocking {
            assertNotNull(getAllFavLocations.invoke())}
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            Truth.assertThat(getAllFavLocations.invoke())
                .isEqualTo(repository.locationEntities)}

    }
}