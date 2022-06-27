package com.magednan.mortyapp.persention.episodeDetails

import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode

data class EpisodeDetailsState(val data:List<Character>?=null,
                               val isLoading:Boolean=false,
                               val fromLocalDb:Boolean=false,
                               val isDbEmpty:Boolean=false,
                               val errorMessage:String?=null)
