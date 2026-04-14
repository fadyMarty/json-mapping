package com.fadymarty.jsonmapping.data.mappers

import com.fadymarty.jsonmapping.data.data_source.remote.dto.PokemonListDto
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

fun JsonObject.toPokemonListDto(): PokemonListDto {
    return PokemonListDto(
        count = this["count"]!!.jsonPrimitive.int,
        next = this["next"]!!.jsonPrimitive.contentOrNull,
        previous = this["previous"]!!.jsonPrimitive.contentOrNull,
        results = this["results"]!!.jsonArray.map {
            it.jsonObject.toPokemonDto()
        }
    )
}