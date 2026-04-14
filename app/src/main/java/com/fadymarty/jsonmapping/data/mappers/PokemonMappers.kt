package com.fadymarty.jsonmapping.data.mappers

import com.fadymarty.jsonmapping.common.util.Constants
import com.fadymarty.jsonmapping.data.data_source.remote.dto.PokemonDto
import com.fadymarty.jsonmapping.domain.model.Pokemon
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

fun JsonObject.toPokemonDto(): PokemonDto {
    return PokemonDto(
        name = this["name"]!!.jsonPrimitive.content,
        url = this["url"]!!.jsonPrimitive.content
    )
}

fun PokemonDto.toPokemon(): Pokemon {
    val id = url.dropLast(1).takeLastWhile { it.isDigit() }

    return Pokemon(
        name = name.replaceFirstChar { it.titlecase() },
        url = url,
        imageUrl = Constants.getImageUrlById(id)
    )
}