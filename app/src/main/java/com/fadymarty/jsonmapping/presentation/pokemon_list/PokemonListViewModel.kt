package com.fadymarty.jsonmapping.presentation.pokemon_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadymarty.jsonmapping.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val pokemonRepository: PokemonRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            pokemonRepository.getPokemons()
                .onSuccess { pokemons ->
                    _state.update {
                        it.copy(pokemons = pokemons)
                    }
                    Log.d("PokemonListViewModel", pokemons.toString())
                }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}