package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.data.retrofit.responses.Sprites
import com.example.pokedex.ui.jet_comp.ExpandableBox

@Composable
fun SpritesBox(sprites: Sprites, modifier: Modifier = Modifier) {
    ExpandableBox(
        headTitle = stringResource(id = R.string.sprites),
        modifier = modifier,
        expandedHeight = 300
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(120.dp)) {
            item { SpriteImage(url = sprites.frontDefault) }
            item { SpriteImage(url = sprites.backDefault) }
            item { SpriteImage(url = sprites.frontShiny) }
            item { SpriteImage(url = sprites.backShiny) }
        }
    }
}