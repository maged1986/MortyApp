package com.magednan.mortyapp.persention.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@Composable
fun NavDrawer() {
    val navController = rememberNavController()
    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()
    val context= LocalContext.current
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
        TopAppBar(
            title = {
                Text(text = "")
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            navigationIcon = {
                IconButton(onClick ={scope.launch { scaffoldState.drawerState.open() }

                }) {
                    Icon(
                        Icons.Default.Menu
                        ,contentDescription = "NavigationMenu")
                }
            }
        )
    },

        drawerContent = {
            //NavHeader()
            DrawerMenu(listOf(
                DrawerMItem(
                    id = "home",
                    title = "Home",
                    icon = Icons.Default.Home
                ),
                DrawerMItem(
                    id = "character",
                    title = "Characters",
                    icon = Icons.Default.Person
                ),
                DrawerMItem(
                    id = "fav_characters",
                    title = "Favorite Characters",
                    icon = Icons.Outlined.Person
                ),DrawerMItem(
                    id = "episode",
                    title = "Episode",
                    icon = Icons.Default.Movie
                ),DrawerMItem(
                    id = "fav_episode",
                    title = "Favorite Episode",
                    icon = Icons.Outlined.Movie
                ),DrawerMItem(
                    id = "location",
                    title = "Location",
                    icon = Icons.Default.LocationOn
                ),DrawerMItem(
                    id = "fav_location",
                    title = "Favorite Location",
                    icon = Icons.Outlined.LocationOn
                )
            ), onItemClick = {
                when (it.id){
                    "home"->{
                         navController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",false)
                         navController.navigate(NavDestination.Home.route)
                        Toast.makeText(context,"home", Toast.LENGTH_SHORT).show()}
                    "character"->{
                           navController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",false)
                           navController.navigate(NavDestination.Character.route)
                        Toast.makeText(context,"character", Toast.LENGTH_SHORT).show()}
                    "fav_characters"->{
                        navController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",true)
                        navController.navigate(NavDestination.Character.route)
                        Toast.makeText(context,"fav_characters", Toast.LENGTH_SHORT).show()}
                    "episode"->{ navController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",false)
                        navController.navigate(NavDestination.Episode.route)
                        Toast.makeText(context,"episode", Toast.LENGTH_SHORT).show()}
                    "fav_episode"->{ navController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",true)
                        navController.navigate(NavDestination.Episode.route)
                        Toast.makeText(context,"fav_episode", Toast.LENGTH_SHORT).show()}
                    "location"->{navController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",false)
                        navController.navigate(NavDestination.Location.route)
                        Toast.makeText(context,"location", Toast.LENGTH_SHORT).show()}
                    "fav_location"->{navController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",true)
                        navController.navigate(NavDestination.Location.route)
                        Toast.makeText(context,"fav_location", Toast.LENGTH_SHORT).show()}
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }, modifier = Modifier.fillMaxSize()
    ) {
        NavGraph(navController)
    }
}