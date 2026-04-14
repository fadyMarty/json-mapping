package com.fadymarty.jsonmapping.data.data_source.repository

import com.fadymarty.jsonmapping.common.util.safeCall
import com.fadymarty.jsonmapping.data.data_source.remote.PokeApi
import com.fadymarty.jsonmapping.data.mappers.toPokemon
import com.fadymarty.jsonmapping.data.mappers.toPokemonListDto
import com.fadymarty.jsonmapping.domain.model.Pokemon
import com.fadymarty.jsonmapping.domain.repository.PokemonRepository
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

class PokemonRepositoryImpl(
    private val pokeApi: PokeApi,
    private val json: Json,
) : PokemonRepository {

    override suspend fun getPokemons(): Result<List<Pokemon>> {
        return safeCall {
            json.parseToJsonElement(pokeApi.getPokemons().string())
                .jsonObject
                .toPokemonListDto()
                .results
                .map { it.toPokemon() }
        }
    }
}