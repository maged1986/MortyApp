package com.magednan.mortyapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val name:String,
    val episode: List<String>?,
    val status:String,
    val species:String,
    val type:String?,
    val gender:String,
    val origin:String?,
    val location:String,
    val image_url:String,
)
