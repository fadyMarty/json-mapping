package com.fadymarty.jsonmapping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.fadymarty.jsonmapping.common.theme.PokemonTheme
import com.fadymarty.jsonmapping.presentation.pokemon_list.PokemonListRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    PokemonListRoot()
                }
            }
        }
    }
}