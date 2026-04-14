package com.fadymarty.jsonmapping.data.data_source.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int = 100,
    ): ResponseBody
}