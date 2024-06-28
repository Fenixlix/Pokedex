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

    private var offset = 0
    private val limit = 40
    private var reachedEnd = false

    var pokeList = mutableStateOf(listOf<Pokemon>())
        private set

    var isLoading = mutableStateOf(true)
        private set

    init {
        getPokeList()
    }

    fun getPokeList() {
        if (!reachedEnd) {
            isLoading.value = true
            viewModelScope.launch {
                try {
                    val response = pokeApi.getPkList(offset = offset, limit = limit)
                    val newList = mutableListOf<Pokemon>()
                    response.results.forEach { pk ->
                        newList.add(Pokemon(name = pk.name, id = getPkId(pk.url)))
                    }

                    offset += newList.size
                    if (offset >= response.count) {
                        reachedEnd = true
                    }

                    pokeList.value += newList
                    isLoading.value = false

                } catch (e: Exception) {
                    isLoading.value = false
                    Log.e("HomeScreen", "fun getPokeList: ${e.message}", e.cause)
                }
            }
        }
    }
}

private fun getPkId(url: String) = if (url.endsWith("/")) {
    url.dropLast(1).takeLastWhile { it.isDigit() }.toInt()
} else {
    url.takeLastWhile { it.isDigit() }.toInt()
}