package com.magednan.mortyapp.persention.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.magednan.mortyapp.utils.Constants


@Composable
fun ImageButton(
    imageUrl: String, modifier: Modifier, title: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)) {
            Image(
                painter = rememberImagePainter(data = imageUrl,
                    builder = {
                        crossfade(true)
                    }),
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
                alignment = Alignment.CenterStart
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black), startY = 30f
                    )
                ),
                contentAlignment = Alignment.BottomCenter) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 22.sp
                    )
                )


            }



        }
    }
}