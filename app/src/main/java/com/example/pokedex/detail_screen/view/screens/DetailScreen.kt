package com.example.pokedex.detail_screen.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.detail_screen.view.jet_comp.NextPrevButtons
import com.example.pokedex.detail_screen.viewmodel.DetailViewModel
import com.example.pokedex.home_screen.model.Pokemon
import com.example.pokedex.home_screen.view.jet_comp.PokemonCard
import com.example.pokedex.ui.jet_comp.DataValidation
import com.example.pokedex.ui.jet_comp.PkScreenColumn

@Composable
fun DetailScreen(
    pkId: String,
    viewModel: DetailViewModel = hiltViewModel(),
    onNextOrPrevClick: (Int) -> Unit
) {
    val currentPokemon = viewModel.pokemon.value
    LaunchedEffect(key1 = true) {
        viewModel.pokeSearch(pkId)
    }

    PkScreenColumn {
        DataValidation(
            isLoading = viewModel.isLoading.value,
            hasEmptyData = currentPokemon == null
        ) {
            PokemonCard(pokemon = Pokemon(name = currentPokemon!!.name, id = currentPokemon.id)) {

            }
        }

        if (currentPokemon != null) {
            NextPrevButtons(currentId = currentPokemon.id) {
                onNextOrPrevClick(it)
            }
        }
    }
}