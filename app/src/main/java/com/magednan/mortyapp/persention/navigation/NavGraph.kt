package com.magednan.mortyapp.persention.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.models.Location
import com.magednan.mortyapp.persention.character.Character
import com.magednan.mortyapp.persention.characterDetails.CharacterDetails
import com.magednan.mortyapp.persention.episode.Episode
import com.magednan.mortyapp.persention.episodeDetails.EpisodeDetails
import com.magednan.mortyapp.persention.home.Home
import com.magednan.mortyapp.persention.location.Location
import com.magednan.mortyapp.persention.locationDetails.LocationDetails


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavDestination.Home.route
    ) {
        composable(NavDestination.Home.route) { Home(navHostController = navController) }
        composable(NavDestination.Character.route) {
            val fromLocalDb =
                navController.previousBackStackEntry?.savedStateHandle?.get<Boolean>("fromLocalDb")
            fromLocalDb?.let {
                Character(fromLocalDb = fromLocalDb, navHostController = navController)
            }

        }
        composable(NavDestination.CharacterDetails.route) {
            val fromLocalDb =
                navController.previousBackStackEntry?.savedStateHandle?.get<Boolean>("fromLocalDb")
            val character =
                navController.previousBackStackEntry?.savedStateHandle?.get<Character>("character")
            if (fromLocalDb != null && character != null) {
                CharacterDetails(
                    navHostController = navController,
                    character = character,
                    fromLocalDb = fromLocalDb
                )
            }
        }

        composable(NavDestination.Episode.route) {
            val fromLocalDb =
                navController.previousBackStackEntry?.savedStateHandle?.get<Boolean>("fromLocalDb")
            fromLocalDb?.let {
                Episode(fromLocalDb = fromLocalDb, navHostController = navController)
            }
        }
        composable(NavDestination.Location.route) {
            val fromLocalDb =
                navController.previousBackStackEntry?.savedStateHandle?.get<Boolean>("fromLocalDb")
            fromLocalDb?.let {
                Location(fromLocalDb = fromLocalDb, navHostController = navController)
            }
        }
        composable(NavDestination.EpisodeDetails.route) {
            val fromLocalDb =
                navController.previousBackStackEntry?.savedStateHandle?.get<Boolean>("fromLocalDb")
            val episode =
                navController.previousBackStackEntry?.savedStateHandle?.get<Episode>("episode")
            if (fromLocalDb != null && episode != null) {
                EpisodeDetails(
                    navHostController = navController,
                    episode = episode,
                    fromLocalDb = fromLocalDb
                )
            }
        }
        composable(NavDestination.LocationDetails.route) {
            val fromLocalDb =
                navController.previousBackStackEntry?.savedStateHandle?.get<Boolean>("fromLocalDb")
            val location =
                navController.previousBackStackEntry?.savedStateHandle?.get<Location>("location")
            if (fromLocalDb != null && location != null) {
                LocationDetails(
                    navHostController = navController,
                    location = location!!,
                    fromLocalDb = fromLocalDb
                )
            }
        }
    }}