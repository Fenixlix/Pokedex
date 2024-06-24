package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pokedex.R
import com.example.pokedex.detail_screen.model.PokemonDetails
import com.example.pokedex.ui.jet_comp.PkText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(currentPokemon: PokemonDetails?, modifier: Modifier = Modifier, size: Int = 24) {
    TopAppBar(
        title = {
            if (currentPokemon == null) {
                PkText(
                    text = stringResource(id = R.string.empty_pokemon_name),
                    size = 32
                )
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PkText(text = currentPokemon.name, size = size)
                    PkText(text = " #${currentPokemon.id}", size = size)
                }
            }
        }, modifier = modifier,
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}