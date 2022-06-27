package com.magednan.mortyapp.persention.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DrawerMenu(
    list: List<DrawerMItem>,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick:(DrawerMItem)-> Unit,
) {
    LazyColumn(modifier = modifier) {
        items(list) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
                .padding(16.dp)
            ) {

                Icon(imageVector = item.icon, contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = textStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}