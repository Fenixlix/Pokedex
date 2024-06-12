package com.example.pokedex.home_screen.view.screens

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
    PkScreenColumn {
        HomeScreenTopBar(onSearchClick = { onPokemonClickOrSearch(it) })
        DataValidation(
            isLoading = viewModel.isLoading.value,
            hasEmptyData = viewModel.pokeList.value.isEmpty()
        ) {
            PkList(pokemonList = viewModel.pokeList.value) { onPokemonClickOrSearch(it.toString()) }
        }
    }
}