package com.magednan.mortyapp.persention.navigation


sealed class NavDestination(val route:String){
    object Home:NavDestination("Home")
    object Character:NavDestination("Character")
    object Episode:NavDestination("Episode")
    object Location:NavDestination("Location")
    object CharacterDetails:NavDestination("CharacterDetails")
    object EpisodeDetails:NavDestination("EpisodeDetails")
    object LocationDetails:NavDestination("LocationDetails")
}
