package com.example.pokedex.home_screen.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.retrofit.PokeApiService
import com.example.pokedex.home_screen.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokeApi: PokeApiService
) : ViewModel() {

    var pokeList = mutableStateOf(listOf<Pokemon>())
        private set

    var isLoading = mutableStateOf(true)
        private set

    init {
        getPokeList(offset = 0)
    }

    fun getPokeList(offset: Int, limit: Int = 40) {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = pokeApi.getPkList(offset = offset, limit = limit)
                val newList = mutableListOf<Pokemon>()
                response.results.forEachIndexed { index, pk ->
                    newList.add(Pokemon(name = pk.name, id = index + offset + 1))
                }
                pokeList.value = newList
                isLoading.value = false
            } catch (e: Exception) {
                isLoading.value = false
                Log.e("HomeScreen", "fun getPokeList: ${e.message}", e.cause)
            }
        }
    }
}