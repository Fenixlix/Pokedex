package com.example.pokedex.home_screen.view.jet_comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.home_screen.model.Pokemon

@Composable
fun PkList(
    pokemonList: List<Pokemon>,
    state: LazyGridState,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
    needToLoad: () -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(130.dp),
        state = state,
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        itemsIndexed(pokemonList) { index, pokemon ->
            if (index >= pokemonList.size - 10) {
                needToLoad()
            }
            PokemonCard(pokemon = pokemon, onClick = { onClick(it) })
        }
    }
}