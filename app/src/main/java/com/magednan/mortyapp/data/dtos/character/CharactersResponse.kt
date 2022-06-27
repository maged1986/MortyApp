package com.magednan.mortyapp.data.dtos.character

import com.google.gson.annotations.SerializedName

data class CharactersResponse(   val info: Info,
                                 @SerializedName("results")
                                 val results: List<CharacterDto>)
