package com.magednan.mortyapp.persention.rvItems

import coil.compose.rememberImagePainter
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.utils.Constants.EPISODE_IMAGE_URL

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun EpisodeRvItem(
    episode: Episode,
    navHostController:NavHostController,
    fromLocalDb: Boolean,
    onSaveCharacterClick: () -> Unit, onDeleteCharacterClick: () -> Unit
) {

    if (episode != null) {
        Box(modifier = Modifier
            .clickable {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",fromLocalDb)
                navHostController.currentBackStackEntry?.savedStateHandle?.set("episode",episode!!)
                navHostController.navigate(com.magednan.mortyapp.persention.navigation.NavDestination.EpisodeDetails.route)
            }
            .fillMaxWidth().padding(5.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(15.dp))) {
            Column() {
                Row(
                    Modifier
                        .padding(3.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                ) {
                    Image(
                        painter = rememberImagePainter(data = EPISODE_IMAGE_URL,
                            builder = {
                                crossfade(true)
                            }),
                        contentDescription = "",
                        contentScale = ContentScale.FillHeight,
                        alignment = Alignment.CenterStart,
                        modifier = Modifier.size(150.dp)
                    )

                    Column(Modifier.padding(10.dp)) {
                        Text(text = "Name: ${episode.name}")
                       Text(text = "Air Date: ${episode.air_date}")
                       Text(text = "Air Date: ${episode.air_date}")
                       Text(text = "Air Date: ${episode.air_date}")
                        //Text(text = "Created: ${episode.created}")
                        //Text(text = "Created: ${episode.created}")
                    }

                }
            }


            if (fromLocalDb) {
                IconButton(
                    onClick = { onDeleteCharacterClick() },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            } else {
                IconButton(
                    onClick = { onSaveCharacterClick() },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Save,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(5.dp))
    }

}

