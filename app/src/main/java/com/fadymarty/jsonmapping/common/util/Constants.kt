package com.fadymarty.jsonmapping.common.util

object Constants {

    const val BASE_URL = "https://pokeapi.co/api/v2/"

    fun getImageUrlById(id: String): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/$id.gif"
    }
}