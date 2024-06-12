package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.data.retrofit.responses.Move
import com.example.pokedex.ui.jet_comp.ExpandableBox

@Composable
fun MovesBox(moves: List<Move>, modifier: Modifier = Modifier) {
    ExpandableBox(
        headTitle = stringResource(id = R.string.moves),
        modifier = modifier,
        expandedHeight = 400
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            items(moves) {
                MoveContainer(move = it)
            }
        }
    }
}