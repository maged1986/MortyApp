package com.magednan.mortyapp.data.local

import androidx.room.*
import com.magednan.mortyapp.data.local.entities.EpisodeEntity


@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavEpisode(episodeEntity: EpisodeEntity)

    @Query("select * from episodes")
    suspend fun getAllFavEpisodes():List<EpisodeEntity>

    @Delete
    suspend fun deleteFavEpisode(episodeEntity: EpisodeEntity)
}