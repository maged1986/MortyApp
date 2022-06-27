package com.magednan.mortyapp.domain.models

import java.io.Serializable

data class Character(  val id:Int,
                       val name:String,
                       val episode: List<String>?,
                       val status:String,
                       val species:String,
                       val type:String?,
                       val gender:String,
                       val origin:String?,
                       val location:String,
                       val image_url:String,):Serializable
