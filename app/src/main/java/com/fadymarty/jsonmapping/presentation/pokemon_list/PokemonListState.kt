package com.fadymarty.jsonmapping.presentation.pokemon_list

import com.fadymarty.jsonmapping.domain.model.Category

data class PokemonListState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
)
