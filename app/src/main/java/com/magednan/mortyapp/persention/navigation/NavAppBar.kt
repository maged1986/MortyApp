package com.magednan.mortyapp.persention.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable


@Composable
fun NavAppBar(
    onNavIconClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = "")
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = {onNavIconClick()}) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "NavigationMenu")
            }
        }
    )
}