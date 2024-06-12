package com.example.pokedex.detail_screen.view.screens

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.detail_screen.model.getTypeList
import com.example.pokedex.detail_screen.view.jet_comp.AbilitiesBox
import com.example.pokedex.detail_screen.view.jet_comp.CustomDivider
import com.example.pokedex.detail_screen.view.jet_comp.CustomRow
import com.example.pokedex.detail_screen.view.jet_comp.MovesBox
import com.example.pokedex.detail_screen.view.jet_comp.NextPrevButtons
import com.example.pokedex.detail_screen.view.jet_comp.PkDimensionsRow
import com.example.pokedex.detail_screen.view.jet_comp.SpritesBox
import com.example.pokedex.detail_screen.view.jet_comp.TypeContainer
import com.example.pokedex.detail_screen.viewmodel.DetailViewModel
import com.example.pokedex.ui.jet_comp.DataValidation
import com.example.pokedex.ui.jet_comp.PkImage
import com.example.pokedex.ui.jet_comp.PkScreenColumn
import com.example.pokedex.ui.jet_comp.PkText

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

    PkScreenColumn(modifier = Modifier.verticalScroll(state = scrollState)) {
        DataValidation(
            isLoading = viewModel.isLoading.value,
            hasEmptyData = currentPokemon == null
        ) {
            if (currentPokemon != null) {
                CustomRow {
                    PkText(text = currentPokemon.name, size = 24)
                    PkText(text = " #${currentPokemon.id}", size = 24)
                }
                PkImage(id = currentPokemon.id, size = 200)

                CustomRow {
                    currentPokemon.getTypeList().forEach {
                        TypeContainer(type = it)
                    }
                }

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

        if (currentPokemon != null) {
            NextPrevButtons(currentId = currentPokemon.id) {
                onNextOrPrevClick(it)
            }
        }
    }
}

