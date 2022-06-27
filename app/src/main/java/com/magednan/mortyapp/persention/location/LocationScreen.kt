package com.magednan.mortyapp.persention.location

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.magednan.mortyapp.persention.episode.EpisodeViewModel
import com.magednan.mortyapp.persention.errorScreen.ErrorScreen
import com.magednan.mortyapp.persention.rvItems.EpisodeRvItem
import com.magednan.mortyapp.persention.rvItems.LocationRvItem

@Composable
fun Location (  fromLocalDb: Boolean,
                navHostController: NavHostController,
                viewModel: LocationViewModel = hiltViewModel()
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
                        LocationRvItem(
                            location = item,
                            navHostController = navHostController,
                            onSaveCharacterClick = { viewModel.insertLocation(item)
                                Toast.makeText(context,"You saved this episode to favorite character",
                                    Toast.LENGTH_LONG).show()},
                            onDeleteCharacterClick = {
                                viewModel.deleteLocation(item)
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