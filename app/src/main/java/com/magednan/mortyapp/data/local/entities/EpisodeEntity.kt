package com.magednan.mortyapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="episodes" )
data class EpisodeEntity(
    val air_date: String,
    val characters: List<String>?,
    val created: String,
    val episode: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val url: String
)
