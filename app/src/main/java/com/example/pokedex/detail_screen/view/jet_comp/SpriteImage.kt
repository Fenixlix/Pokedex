package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.R

@Composable
fun SpriteImage(url: String, modifier: Modifier = Modifier, size: Int = 120) {
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