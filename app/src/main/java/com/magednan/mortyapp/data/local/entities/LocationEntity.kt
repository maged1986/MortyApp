package com.magednan.mortyapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "locations")
data class LocationEntity(
    val created: String,
    val dimension: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val residents: List<String>?,
    val type: String,
    val url: String
)
