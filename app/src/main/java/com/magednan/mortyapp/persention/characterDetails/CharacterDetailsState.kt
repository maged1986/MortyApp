package com.magednan.mortyapp.persention.characterDetails

import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode

data class CharacterDetailsState(val data:List<Episode>?=null,
                                 val isLoading:Boolean=false,
                                 val fromLocalDb:Boolean=false,
                                 val isDbEmpty:Boolean=false,
                                 val errorMessage:String?=null)
