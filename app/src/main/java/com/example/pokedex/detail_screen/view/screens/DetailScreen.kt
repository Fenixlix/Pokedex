package com.example.pokedex.detail_screen.view.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.detail_screen.model.getTypeList
import com.example.pokedex.detail_screen.view.jet_comp.AbilitiesBox
import com.example.pokedex.detail_screen.view.jet_comp.CustomDivider
import com.example.pokedex.detail_screen.view.jet_comp.DetailsBottomBar
import com.example.pokedex.detail_screen.view.jet_comp.DetailsTopBar
import com.example.pokedex.detail_screen.view.jet_comp.MovesBox
import com.example.pokedex.detail_screen.view.jet_comp.PkDimensionsRow
import com.example.pokedex.detail_screen.view.jet_comp.PkTypesRow
import com.example.pokedex.detail_screen.view.jet_comp.SpritesBox
import com.example.pokedex.detail_screen.viewmodel.DetailViewModel
import com.example.pokedex.ui.jet_comp.DataValidation
import com.example.pokedex.ui.jet_comp.PkImage
import com.example.pokedex.ui.jet_comp.PkScreenColumn

@Composable
fun DetailScreen(
    pkId: String,
    viewModel: DetailViewModel = hiltViewModel(),
    onNextOrPrevClick: (Int) -> Unit
) {
    val currentPokemon = viewModel.pokemon.value
    val scrollState = rememberScrollState()
    LaunchedEffect(key1 = true) {
        viewModel.pokeSearch(pkId)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { DetailsTopBar(currentPokemon = currentPokemon) },
        bottomBar = {
            DetailsBottomBar(
                currentPokemon = currentPokemon,
                onClick = { onNextOrPrevClick(it) })
        }) { paddingValues ->

        DataValidation(
            isLoading = viewModel.isLoading.value,
            hasEmptyData = currentPokemon == null
        ) {
            PkScreenColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(state = scrollState)
            ) {
                if (currentPokemon != null) {
                    PkImage(id = currentPokemon.id, size = 200)

                    PkTypesRow(pkTypeList = currentPokemon.getTypeList())

                    CustomDivider()

                    PkDimensionsRow(
                        height = currentPokemon.height.toString(),
                        weight = currentPokemon.weight.toString()
                    )

                    SpritesBox(sprites = currentPokemon.sprites)

                    AbilitiesBox(abilities = currentPokemon.abilities)

                    MovesBox(moves = currentPokemon.moves)
                }
            }
        }
    }
}

