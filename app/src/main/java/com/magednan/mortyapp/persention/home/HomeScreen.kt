package com.magednan.mortyapp.persention.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.magednan.mortyapp.persention.character.CharacterViewModel
import com.magednan.mortyapp.persention.episode.EpisodeViewModel
import com.magednan.mortyapp.persention.location.LocationViewModel
import com.magednan.mortyapp.persention.navigation.NavDestination
import com.magednan.mortyapp.persention.rvItems.CharacterRvScreen
import com.magednan.mortyapp.persention.rvItems.EpisodeRvItem
import com.magednan.mortyapp.persention.rvItems.LocationRvItem
import com.magednan.mortyapp.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Home(
    navHostController: NavHostController,
    locationViewModel: LocationViewModel = hiltViewModel(),
    episodeViewModel: EpisodeViewModel = hiltViewModel(),
    characterViewModel: CharacterViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        Text(text = "Main Characters", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .height(400.dp).padding(vertical = 5.dp)
        ) {
            characterViewModel.getAllCharacters(false)
            characterViewModel.state.data?.size?.let {
                items(it) { index ->
                    val item = characterViewModel.state.data?.get(index)
                    if (item != null) {
                        Log.d("TAG", "Character:${item.toString()} ")
                        CharacterRvScreen(
                            character = item,
                            navHostController = navHostController,
                            onSaveCharacterClick = {
                                characterViewModel.insertAFavCharacter(item)
                                Toast.makeText(
                                    context, "You saved this character to favorite character",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            onDeleteCharacterClick = {
                                characterViewModel.deleteFavCharacter(item)
                                Toast.makeText(
                                    context, "You deleted this character from favorite character",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            fromLocalDb = false
                        )
                    }
                }
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 5.dp)) {
            ImageButton(imageUrl = Constants.Character_IMAGE_URL,
                modifier = Modifier
                .clickable {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set(
                        "fromLocalDb",
                        false
                    )
                    navHostController.navigate(NavDestination.Character.route)
                }
                .weight(1f), title = "Character")
            ImageButton(imageUrl = Constants.LOCATION_IMAGE_URL,
                modifier = Modifier
                .clickable {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set(
                        "fromLocalDb",
                        false
                    )
                    navHostController.navigate(NavDestination.Location.route)
                }
                .weight(1f), title = "Location")
            ImageButton(imageUrl = Constants.EPISODE_IMAGE_URL,
                modifier = Modifier
                .clickable {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set(
                        "fromLocalDb",
                        false
                    )
                    navHostController.navigate(NavDestination.Episode.route)
                }
                .weight(1f), title ="Episode")
        }

        LazyRow(
            Modifier
                .fillMaxWidth()
                .height(120.dp).padding(vertical = 5.dp)
        ) {
            episodeViewModel.getAllEpisodes(false)
            episodeViewModel.state.data?.size?.let {
                items(it) { index ->
                    val item = episodeViewModel.state.data?.get(index)
                    if (item != null) {
                        Log.d("TAG", "Episode:${item.toString()} ")
                        EpisodeRvItem(
                            episode = item,
                            navHostController = navHostController,
                            onSaveCharacterClick = {
                                episodeViewModel.insertFavEpisode(item)
                                Toast.makeText(
                                    context, "You saved this episode to favorite character",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            onDeleteCharacterClick = {
                                episodeViewModel.deleteFavEpisode(item)
                                Toast.makeText(
                                    context, "You deleted this episode from favorite character",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            fromLocalDb = false
                        )
                    }
                }
            }
        }

        Text(
            text = "Main Locations",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        LazyRow(
            Modifier
                .fillMaxWidth()
                .height(120.dp).padding(vertical = 5.dp)
        ) {
            locationViewModel.getAllEpisodes(false)
            locationViewModel.state.data?.size?.let {
                items(it) { index ->
                    val item = locationViewModel.state.data?.get(index)
                    if (item != null) {
                        Log.d("TAG", "Episode:${item.toString()} ")
                        LocationRvItem(
                            location = item,
                            navHostController = navHostController,
                            onSaveCharacterClick = {
                                locationViewModel.insertLocation(item)
                                Toast.makeText(
                                    context, "You saved this episode to favorite character",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            onDeleteCharacterClick = {
                                locationViewModel.deleteLocation(item)
                                Toast.makeText(
                                    context, "You deleted this episode from favorite character",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            fromLocalDb = false
                        )
                    }
                }
            }
        }
    }
}