package com.fadymarty.jsonmapping.data.data_source.remote

import okhttp3.ResponseBody
import retrofit2.http.GET

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemons(): ResponseBody
}