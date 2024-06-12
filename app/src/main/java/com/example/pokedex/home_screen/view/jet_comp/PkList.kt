package com.example.pokedex.home_screen.view.jet_comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.home_screen.model.Pokemon

@Composable
fun PkList(pokemonList: List<Pokemon>, modifier: Modifier = Modifier, onClick: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(130.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(pokemonList) { pokemon ->
            PokemonCard(pokemon = pokemon, onClick = { onClick(it) })
        }
    }
}