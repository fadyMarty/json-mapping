package com.fadymarty.jsonmapping.domain.repository

import com.fadymarty.jsonmapping.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemons(): Result<List<Pokemon>>
}