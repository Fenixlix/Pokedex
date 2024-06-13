package com.example.pokedex.home_screen.view.jet_comp

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.home_screen.model.Pokemon
import com.example.pokedex.ui.jet_comp.PkImage
import com.example.pokedex.ui.jet_comp.PkText

@Composable
fun PokemonCard(pokemon: Pokemon, modifier: Modifier = Modifier, onClick: (Int) -> Unit) {
    Column(
        modifier = modifier
            .padding(4.dp)
            .width(130.dp)
            .wrapContentHeight()
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(25f)
            )
            .clickable { onClick(pokemon.id) }
            .padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PkText(text = pokemon.name)
        PkText(text = "#${pokemon.id}")
        PkImage(id = pokemon.id)
    }
}

