package com.fadymarty.jsonmapping.presentation.pokemon_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fadymarty.jsonmapping.presentation.pokemon_list.components.CategoryHeader
import com.fadymarty.jsonmapping.presentation.pokemon_list.components.PokemonItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PokemonListRoot(
    viewModel: PokemonListViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    PokemonListScreen(state)
}

@Composable
private fun PokemonListScreen(
    state: PokemonListState,
) {
    val layoutDirection = LocalLayoutDirection.current

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            contentPadding = PaddingValues(
                start = innerPadding.calculateStartPadding(layoutDirection),
                end = innerPadding.calculateEndPadding(layoutDirection),
                bottom = innerPadding.calculateBottomPadding() + 32.dp
            ),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            state.categories.forEach { category ->
                stickyHeader {
                    CategoryHeader(category.name)
                }
                items(category.pokemons) { pokemon ->
                    PokemonItem(pokemon)
                }
            }
        }
    }
}