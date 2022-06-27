package com.magednan.mortyapp.persention.locationDetails

import com.magednan.mortyapp.domain.models.Character

data class LocationDetailsState(val data:List<Character>?=null,
                                val isLoading:Boolean=false,
                                val fromLocalDb:Boolean=false,
                                val isDbEmpty:Boolean=false,
                                val errorMessage:String?=null)
