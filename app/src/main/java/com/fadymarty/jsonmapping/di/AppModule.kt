package com.fadymarty.jsonmapping.di

import com.fadymarty.jsonmapping.common.util.Constants
import com.fadymarty.jsonmapping.data.data_source.remote.PokeApi
import com.fadymarty.jsonmapping.data.data_source.repository.PokemonRepositoryImpl
import com.fadymarty.jsonmapping.domain.repository.PokemonRepository
import com.fadymarty.jsonmapping.presentation.pokemon_list.PokemonListViewModel
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(get())
            .build()
            .create(PokeApi::class.java)
    }
    single {
        Json { ignoreUnknownKeys = true }
    }

    singleOf(::PokemonRepositoryImpl) { bind<PokemonRepository>() }

    viewModelOf(::PokemonListViewModel)
}