package com.magednan.mortyapp.persention

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.magednan.mortyapp.persention.navigation.NavDrawer
import com.magednan.mortyapp.persention.theme.MortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MortyAppTheme {
              NavDrawer()
            }
        }
    }
}