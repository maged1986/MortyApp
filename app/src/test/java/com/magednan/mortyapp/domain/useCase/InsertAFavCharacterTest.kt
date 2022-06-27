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

class InsertAFavCharacterTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var insertAFavCharacter: InsertAFavCharacter
    val repository = FakeRepository()

    val characterEntity = CharacterEntity(
        111,
        "nbnbnb",
        emptyList(),
        "m,m,",
        "nmnm",
        "nmn",
        "nmnm",
        "nmnm",
        "nmnm",
        "nmnmn"
    )

    @Before
    fun setup() {
        insertAFavCharacter= InsertAFavCharacter(repository)
        runBlocking {
            repository.insert(characterEntity)}
    }


    @Test
    fun assertNotNull() {
        assertNotNull(characterEntity)
    }

    @Test
    fun makeItPasses() {
        runBlocking {
            Truth.assertThat(repository.getAllFavCharacters()).contains(characterEntity)
        }
    }

}