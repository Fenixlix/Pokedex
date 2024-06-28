package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.pokedex.R
import com.example.pokedex.data.retrofit.responses.Move
import java.util.Locale

@Composable
fun MovesBox(moves: List<Move>, modifier: Modifier = Modifier) {
    ExpandableBox(
        headTitle = stringResource(id = R.string.moves),
        modifier = modifier
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(4.dp)
        ) {
            items(moves) {
                MoveContainer(move = it)
            }
        }
    }
}

@Composable
private fun MoveContainer(move: Move, modifier: Modifier = Modifier) {
    val showDialog = remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .clickable { showDialog.value = showDialog.value.not() }
            .width(150.dp)
            .wrapContentHeight()
            .padding(2.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(25)
            )
            .padding(4.dp)
    ) {
        MoveTxt(text = move.move.name, fontSize = 18)
        AnimatedVisibility(showDialog.value) {
            MoveDialog(move = move) {
                showDialog.value = showDialog.value.not()
            }
        }
    }
}

@Composable
private fun MoveTxt(text: String, fontSize: Int = 14) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        textAlign = TextAlign.Start
    )
}

@Composable
private fun MoveDialog(move: Move, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = { onDismiss() }) {
        LazyColumn(
            modifier = Modifier
                .height(320.dp)
                .width(240.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(25f)
                )
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(25f)
                )
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(move.versionGroupDetails) { versionMoveInfo ->
                MoveTxt(
                    text = versionMoveInfo.versionGroup.name.uppercase(Locale.ROOT),
                    fontSize = 16
                )
                Row {
                    MoveTxt(text = versionMoveInfo.moveLearnMethod.name)
                    MoveTxt(text = " Lv:${versionMoveInfo.levelLearnedAt}")
                }
                HorizontalDivider(
                    modifier = Modifier.padding(
                        horizontal = 4.dp
                    )
                )
            }
        }
    }
}