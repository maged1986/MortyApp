package com.magednan.mortyapp.persention.errorScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ErrorScreen(errorMessage:String) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween,Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.Default.Error, contentDescription ="" , modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth())
        Text(text=errorMessage,fontSize = 30.sp,modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth())
    }

}