package com.magednan.mortyapp.persention.rvItems

import android.annotation.SuppressLint
import android.util.JsonReader
import android.util.Log
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.beust.klaxon.Klaxon
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.internal.Streams.parse
import com.google.gson.reflect.TypeToken
import com.magednan.mortyapp.data.dtos.episode.EpisodeDto
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import okio.ByteString.Companion.toByteString
import java.io.IOException
import java.io.Reader
import java.net.URL

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CharacterRvScreen(character: Character,
                      navHostController: NavHostController,
                      fromLocalDb: Boolean,
                      onSaveCharacterClick:()->Unit,onDeleteCharacterClick:()->Unit
) {
    if (character != null) {
        Box(modifier = Modifier
            .clickable {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("fromLocalDb",fromLocalDb)
                navHostController.currentBackStackEntry?.savedStateHandle?.set("character",character!!)
                navHostController.navigate(com.magednan.mortyapp.persention.navigation.NavDestination.CharacterDetails.route)
            }
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(15.dp))) {
           Column() {
            Row(Modifier
                    .padding(3.dp)
                    .clip(shape = RoundedCornerShape(10.dp))) {
                Image(painter = rememberImagePainter(data = character.image_url,
                        builder = {
                            crossfade(true)
                        }),
                    contentDescription = "Flag Poster",
                    contentScale = ContentScale.FillWidth,
                            alignment = Alignment.CenterStart,
                    modifier = Modifier
                        .size(150.dp)
                    // .padding(10.dp)
                )

                Column(Modifier.padding(10.dp)) {
                    Text(text = "Name: ${character.name}")
                    Text(text = "Status: ${character.status}")
                    character.origin?.let { Text(text = "the origin $it") }
                    Text(text = "Gender: ${character.gender}")
                }

            }}


            if(fromLocalDb){
                IconButton(onClick = {onDeleteCharacterClick() },
                    modifier = Modifier.align(Alignment.BottomEnd)) {
                    Icon(imageVector =Icons.Default.Delete , contentDescription ="", tint = Color.White)
                }
            }else{
                IconButton(onClick = {onSaveCharacterClick() },
                    modifier = Modifier.align(Alignment.BottomEnd)) {
                    Icon(imageVector =Icons.Default.Save , contentDescription ="", tint = Color.White )
                }
            }

        }
        Spacer(modifier = Modifier.height(5.dp))}

}

