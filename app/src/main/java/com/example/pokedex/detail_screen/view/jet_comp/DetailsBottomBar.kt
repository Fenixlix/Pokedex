package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pokedex.detail_screen.model.PokemonDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsBottomBar(
    currentPokemon: PokemonDetails?,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    if (currentPokemon != null) {
        BottomAppBar(
            modifier = modifier,
            scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()
        ) {
            NextPrevButtons(currentId = currentPokemon.id) {
                onClick(it)
            }
        }
    }
}

@Composable
private fun NextPrevButtons(
    currentId: Int,
    modifier: Modifier = Modifier,
    onNextOrPrevClick: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomIconBtn(
            text = "#${currentId - 1}",
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = { onNextOrPrevClick(currentId - 1) })
        CustomIconBtn(
            text = "#${currentId + 1}",
            icon = Icons.AutoMirrored.Filled.ArrowForward,
            onClick = { onNextOrPrevClick(currentId + 1) }
        )
    }
}

@Composable
private fun CustomIconBtn(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(contentAlignment = Alignment.TopCenter) {
        IconButton(
            modifier = modifier
                .wrapContentSize()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                ),
            onClick = { onClick() }
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        Text(
            text = text,
            modifier = Modifier
                .padding(4.dp)
                .padding(top = 44.dp),
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold
        )
    }
}