package com.magednan.mortyapp.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.magednan.mortyapp.MainCoroutineRule
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.domain.repository.Repository
import com.magednan.mortyapp.repository.FakeRepository
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DeleteFavCharacterTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var deleteFavCharacter: DeleteFavCharacter
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
        deleteFavCharacter = DeleteFavCharacter(repository)
        runBlocking {
            repository.insert(characterEntity)}
    }


    @Test
    fun assertNotNull() {
        assertNotNull(repository.characterEntities)
    }

    @Test
    fun makeItPasses() {
        runBlocking {
         repository.deleteFavCharacter(characterEntity)
         assertThat(repository.getAllFavCharacters()).doesNotContain(characterEntity)
        }
    }
    @Test
    fun makeItFails() {
        runBlocking {
         repository.deleteFavCharacter(characterEntity)
         assertThat(repository.getAllFavCharacters()).contains(characterEntity)
        }
    }


}