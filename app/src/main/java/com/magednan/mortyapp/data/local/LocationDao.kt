package com.magednan.mortyapp.data.local

import androidx.room.*
import com.magednan.mortyapp.data.local.entities.LocationEntity


@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavLocation(locationEntity: LocationEntity)

    @Query("select * from locations")
    suspend fun getAllFavLocations():List<LocationEntity>

    @Delete
    suspend fun deleteFavLocation(locationEntity: LocationEntity)
}