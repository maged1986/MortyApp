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

class GetCharactersTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var getCharacters: GetCharacters
    val repository = FakeRepository()
    val successState = Resource.Success(data = repository.characters)
    val errorSate = Resource.Error(errorMessage = "Here is an error ")
    val loadingState = Resource.Loading


    @Before
    fun setup() {
        getCharacters= GetCharacters(repository)
    }

    @Test
    fun assertNotNull() {
        runBlocking {
            assertNotNull(getCharacters.invoke(emptyList()))}
    }

    @Test
    fun makeSureItIsSuccessState() {
        runBlocking {
            repository.getCharacters(emptyList()).collect {
                Truth.assertThat(it).isEqualTo(successState)
            }
        }
    }

    @Test
    fun makeSureItIsNotLoadingOrErrorState() {
        runBlocking {
            repository.getCharacters(emptyList()).collect {
                Truth.assertThat(it).isNotEqualTo(errorSate)
                Truth.assertThat(it).isNotEqualTo(loadingState)
            }
        }
    }
}