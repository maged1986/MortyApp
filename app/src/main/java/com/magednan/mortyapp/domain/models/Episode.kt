package com.magednan.mortyapp.domain.models

import java.io.Serializable

data class Episode(val air_date: String,
                      val characters: List<String>?,
                      val created: String,
                      val episode: String,
                      val id: Int,
                      val name: String,
                      val url: String):Serializable
