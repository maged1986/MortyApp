package com.magednan.mortyapp.data.local

import androidx.room.*
import com.magednan.mortyapp.data.local.entities.CharacterEntity


@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterEntity: CharacterEntity)

    @Query("select * from characters")
    suspend fun getAllFavCharacters():List<CharacterEntity>

    @Delete
    suspend fun deleteFavCharacter(characterEntity: CharacterEntity)

}