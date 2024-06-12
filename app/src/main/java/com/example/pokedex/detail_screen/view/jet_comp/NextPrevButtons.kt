package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NextPrevButtons(
    currentId: Int,
    modifier: Modifier = Modifier,
    onNextOrPrevClick: (Int) -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            enabled = (currentId - 1) > 0,
            onClick = { onNextOrPrevClick(currentId - 1) }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                Text(text = "# ${currentId - 1}")
            }
        }
        // todo: in future it can be upgrade using store shared preferences and the api response
        IconButton(
            enabled = (currentId + 1) < 1118,
            onClick = { onNextOrPrevClick(currentId + 1) }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                Text(text = "# ${currentId + 1}")
            }
        }
    }
}