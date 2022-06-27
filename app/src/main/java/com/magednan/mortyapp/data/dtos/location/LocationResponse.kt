package com.magednan.mortyapp.data.dtos.location

import com.google.gson.annotations.SerializedName

data class LocationResponse( val info: Info,
                             @SerializedName("results")
                             val locationDtos: List<LocationDto>)
