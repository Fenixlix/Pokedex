package com.example.pokedex.home_screen.view.screens

import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.home_screen.view.jet_comp.HomeScreenTopBar
import com.example.pokedex.home_screen.view.jet_comp.PkList
import com.example.pokedex.home_screen.viewmodel.HomeViewModel
import com.example.pokedex.ui.jet_comp.DataValidation
import com.example.pokedex.ui.jet_comp.PkScreenColumn

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onPokemonClickOrSearch: (String) -> Unit
) {
    val lazyGridState = rememberLazyGridState()

    PkScreenColumn {
        HomeScreenTopBar(onSearchClick = { onPokemonClickOrSearch(it) })
        DataValidation(
            isLoading = viewModel.isLoading.value,
            hasEmptyData = viewModel.pokeList.value.isEmpty()
        ) {
            PkList(
                pokemonList = viewModel.pokeList.value,
                state = lazyGridState,
                onClick = { onPokemonClickOrSearch(it.toString()) },
                needToLoad = { viewModel.getPokeList() })
        }
    }
}