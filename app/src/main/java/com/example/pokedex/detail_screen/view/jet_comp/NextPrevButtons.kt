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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
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

@Composable
fun NextPrevButtons(
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
            icon = Icons.Filled.ArrowBack,
            enabler = (currentId - 1) > 0,
            onClick = { onNextOrPrevClick(currentId - 1) })
        // todo: in future it can be upgrade using store shared preferences and the api response
        CustomIconBtn(
            text = "#${currentId + 1}",
            icon = Icons.Filled.ArrowForward,
            enabler = (currentId + 1) < 1118,
            onClick = { onNextOrPrevClick(currentId + 1) }
        )
    }
}

@Composable
private fun CustomIconBtn(
    text: String,
    icon: ImageVector,
    enabler: Boolean,
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
            enabled = enabler,
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