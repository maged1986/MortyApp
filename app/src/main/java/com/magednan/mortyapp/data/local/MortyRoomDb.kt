package com.magednan.mortyapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.EpisodeEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity

@Database(
    entities = [CharacterEntity::class, EpisodeEntity::class, LocationEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MortyRoomDb: RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
    abstract fun getEpisodeDao(): EpisodeDao
    abstract fun getLocationDao(): LocationDao
}