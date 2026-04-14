package com.fadymarty.jsonmapping.data.data_source.remote.dto

data class PokemonListDto(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonDto>,
)
