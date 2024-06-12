package com.example.pokedex.ui.jet_comp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PkText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    size: Int = 16
) {
    Text(
        text = text.uppercase(),
        modifier = modifier,
        fontWeight = FontWeight.SemiBold,
        fontSize = size.sp,
        textAlign = TextAlign.Center,
        color = color
    )
}