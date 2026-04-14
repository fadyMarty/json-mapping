package com.fadymarty.jsonmapping.presentation.pokemon_list

import com.fadymarty.jsonmapping.domain.model.Pokemon

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList(),
)
