package com.example.pokedex.detail_screen.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.retrofit.PokeApiService
import com.example.pokedex.detail_screen.model.PokemonDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val pokeApi: PokeApiService
) : ViewModel() {

    var pokemon = mutableStateOf<PokemonDetails?>(null)
        private set

    var isLoading = mutableStateOf(true)
        private set

    fun pokeSearch(searchWord: String) {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = pokeApi.getSinglePokemon(searchWord)
                pokemon.value = PokemonDetails(
                    name = response.name,
                    id = response.id,
                    sprites = response.sprites,
                    height = response.height,
                    weight = response.weight,
                    abilities = response.abilities,
                    types = response.types,
                    moves = response.moves
                )
                Log.d("DetailVM", "pokeSearch: ${pokemon.value!!.id}")
                isLoading.value = false
            } catch (e: Exception) {
                isLoading.value = false
                Log.e("DetailScreen", "fun pokeSearch: ${e.message}", e.cause)
            }
        }
    }
}