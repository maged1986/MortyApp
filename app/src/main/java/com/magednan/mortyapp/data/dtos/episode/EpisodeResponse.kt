package com.magednan.mortyapp.data.dtos.episode

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(  val info: Info,
                             @SerializedName("results")
                             val episodeDtos: List<EpisodeDto>)
