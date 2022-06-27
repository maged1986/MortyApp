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

class GetAllFavCharactersTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var getAllFavCharacters: GetAllFavCharacters
    val repository = FakeRepository()



    @Before
    fun setup() {
        getAllFavCharacters= GetAllFavCharacters(repository)
    }

    @Test
    fun assertNotNull() {
        runBlocking {
        assertNotNull(getAllFavCharacters.invoke())}
    }

    @Test
    fun makeItPasses() {
        runBlocking {
                Truth.assertThat(getAllFavCharacters.invoke())
                    .isEqualTo(repository.characterEntities)}

    }
}