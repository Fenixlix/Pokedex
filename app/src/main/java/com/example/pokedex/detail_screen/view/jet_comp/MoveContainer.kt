package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.retrofit.responses.Move

@Composable
fun MoveContainer(move: Move, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(150.dp)
            .height(40.dp)
            .padding(2.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(25)
            )
            .padding(4.dp)
    ) {
        Text(
            text = move.move.name,
            fontSize = 18.sp,
            textAlign = TextAlign.Start
        )
    }
}