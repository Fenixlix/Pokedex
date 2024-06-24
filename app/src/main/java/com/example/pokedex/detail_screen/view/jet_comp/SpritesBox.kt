package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.R
import com.example.pokedex.data.retrofit.responses.Sprites

@Composable
fun SpritesBox(sprites: Sprites, modifier: Modifier = Modifier) {
    ExpandableBox(
        headTitle = stringResource(id = R.string.sprites),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomSpriteBox(title = stringResource(id = R.string.default_sprites)) {
                SpriteImage(url = sprites.frontDefault)
                SpriteImage(url = sprites.backDefault)
            }
            CustomSpriteBox(title = stringResource(id = R.string.shiny_sprites)) {
                SpriteImage(url = sprites.frontShiny)
                SpriteImage(url = sprites.backShiny)
            }
        }
    }
}

@Composable
private fun CustomSpriteBox(
    title: String,
    modifier: Modifier = Modifier,
    rowContent: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Text(text = title)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            rowContent()
        }
    }
}

@Composable
private fun SpriteImage(url: String, modifier: Modifier = Modifier, size: Int = 120) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = null,
        error = painterResource(id = R.drawable.image_placeholder),
        modifier = modifier.size(size.dp),
        placeholder = painterResource(id = R.drawable.image_placeholder)
    )
}