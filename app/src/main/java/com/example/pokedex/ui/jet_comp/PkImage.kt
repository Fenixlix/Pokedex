package com.example.pokedex.ui.jet_comp

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.R

// This composable gets the image of the pokemon of the corresponding id
@Composable
fun PkImage(id: Int, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(
                "https://raw.githubusercontent.com/" +
                        "PokeAPI/sprites/master/sprites/" +
                        "pokemon/other/official-artwork/$id.png"
            )
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = modifier.size(100.dp),
        placeholder = painterResource(id = R.drawable.image_placeholder)
    )
}