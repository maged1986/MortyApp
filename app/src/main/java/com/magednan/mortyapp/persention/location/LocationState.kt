package com.magednan.mortyapp.persention.location

import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.models.Location

data class LocationState(val data:List<Location>?=null,
                         val isLoading:Boolean=false,
                         val fromLocalDb:Boolean=false,
                         val isDbEmpty:Boolean=false,
                         val errorMessage:String?=null)
