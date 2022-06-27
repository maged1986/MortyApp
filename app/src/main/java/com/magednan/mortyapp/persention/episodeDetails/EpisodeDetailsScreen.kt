package com.magednan.mortyapp.persention.episodeDetails

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.persention.characterDetails.CharacterDetailsViewModel
import com.magednan.mortyapp.persention.rvItems.CharacterRvScreen
import com.magednan.mortyapp.persention.rvItems.EpisodeRvItem
import com.magednan.mortyapp.utils.Constants.EPISODE_IMAGE_URL


@Composable
fun EpisodeDetails (fromLocalDb: Boolean,
                    navHostController: NavHostController,
                   viewModel: EpisodeDetailsViewModel = hiltViewModel(),
                   episode: Episode){
    if (episode != null) {
        episode.characters?.let { viewModel.getCharacters((it)) }
        val list = viewModel.state.data
        Log.d("TAG", "CharacterDetails:${viewModel.state.toString()} ")
        Box() {
            Column(Modifier.fillMaxSize()) {
                Image(
                    painter = rememberImagePainter(data =EPISODE_IMAGE_URL ),
                    contentDescription = "",
                    contentScale= ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )
                Text(text = episode.name)
                Text(text = episode.name)
                Text(text = episode.name)
                Text(text = episode.name)
                Text(text = episode.name)
                Text(text = episode.name)

                LazyColumn(
                    modifier = Modifier
                        //  .fillMaxSize(1f)
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    list?.size?.let {
                        items(it) { index ->
                            val item = list.get(index)
                            if (item != null) {
                                Log.d("TAG", "Characternmmnmn:${item.toString()} ")
                                CharacterRvScreen(
                                    character = item,
                                    navHostController = navHostController,
                                    fromLocalDb = false,
                                    onDeleteCharacterClick = {},
                                    onSaveCharacterClick = {})


                            }
                        }
                    }
                }
            }
        }}
}