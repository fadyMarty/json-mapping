package com.fadymarty.jsonmapping.data.mappers

import com.fadymarty.jsonmapping.common.util.Constants
import com.fadymarty.jsonmapping.data.data_source.remote.dto.PokemonDto
import com.fadymarty.jsonmapping.domain.model.Pokemon
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun JsonObject.toPokemonDto(): PokemonDto {
    return PokemonDto(
        name = this["name"]!!.jsonPrimitive.content,
        url = this["url"]!!.jsonPrimitive.content
    )
}

fun PokemonDto.toRequestBody(): RequestBody {
    return buildJsonObject {
        put("name", name)
        put("url", url)
    }
        .toString()
        .toRequestBody("application/json".toMediaType())
}

fun PokemonDto.toPokemon(): Pokemon {
    val id = url.dropLast(1).takeLastWhile { it.isDigit() }

    return Pokemon(
        name = name.replaceFirstChar { it.titlecase() },
        url = url,
        imageUrl = Constants.getImageUrlById(id)
    )
}