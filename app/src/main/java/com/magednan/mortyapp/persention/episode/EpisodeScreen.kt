package com.magednan.mortyapp.persention.episode

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.magednan.mortyapp.persention.errorScreen.ErrorScreen
import com.magednan.mortyapp.persention.navigation.NavDestination
import com.magednan.mortyapp.persention.rvItems.CharacterRvScreen
import com.magednan.mortyapp.persention.rvItems.EpisodeRvItem

@Composable
fun Episode(   fromLocalDb: Boolean,
navHostController: NavHostController,
viewModel: EpisodeViewModel = hiltViewModel()
) {
    viewModel.getAllEpisodes(fromLocalDb)
    val context= LocalContext.current
    val state=viewModel.state
    if (state.errorMessage ==null){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(10.dp)
        ) {
            viewModel.state.data?.size?.let {
                items(it) { index ->
                    val item = viewModel.state.data?.get(index)
                    if (item != null) {
                        Log.d("TAG", "Episode:${item.toString()} ")
                        EpisodeRvItem(
                            episode = item,
                          navHostController = navHostController,
                            onSaveCharacterClick = { viewModel.insertFavEpisode(item)
                                Toast.makeText(context,"You saved this episode to favorite character",
                                    Toast.LENGTH_LONG).show()},
                            onDeleteCharacterClick = {
                                viewModel.deleteFavEpisode(item)
                                Toast.makeText(context,"You deleted this episode from favorite character",
                                    Toast.LENGTH_LONG).show()},
                            fromLocalDb = fromLocalDb
                        )
                    }
                }
            }
        }

    }else{
        ErrorScreen(errorMessage = state.errorMessage)
    }
}
