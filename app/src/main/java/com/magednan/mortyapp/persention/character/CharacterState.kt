package com.magednan.mortyapp.persention.character

import com.magednan.mortyapp.domain.models.Character

data class CharacterState(
    var data:List<Character>?=null,
    val isLoading:Boolean=false,
    val fromLocalDb:Boolean=false,
    val isDbEmpty:Boolean=false,
    val errorMessage:String?=null
)
