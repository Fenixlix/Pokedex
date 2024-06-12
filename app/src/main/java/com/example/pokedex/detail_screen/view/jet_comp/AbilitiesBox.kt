package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.data.retrofit.responses.Ability
import com.example.pokedex.ui.jet_comp.ExpandableBox

@Composable
fun AbilitiesBox(abilities: List<Ability>, modifier: Modifier = Modifier) {
    ExpandableBox(
        headTitle = stringResource(id = R.string.abilities),
        modifier = modifier,
        expandedHeight = 180
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)) {
            items(abilities) {
                AbilityContainer(ability = it)
            }
        }
    }
}