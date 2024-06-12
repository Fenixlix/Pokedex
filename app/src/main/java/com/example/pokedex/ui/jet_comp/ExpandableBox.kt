package com.example.pokedex.ui.jet_comp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.detail_screen.view.jet_comp.CustomDivider

@Composable
fun ExpandableBox(
    headTitle: String,
    modifier: Modifier = Modifier,
    expandedHeight: Int = 300,
    expandContent: @Composable () -> Unit
) {
    val expanded = remember { mutableStateOf(false) }

    val height = if (expanded.value) expandedHeight.dp else 50.dp

    Box(
        modifier = modifier
            .clickable { expanded.value = expanded.value.not() }
            .padding(4.dp)
            .fillMaxWidth()
            .height(height)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(10)
            )
            .padding(4.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                PkText(text = headTitle, modifier = Modifier.padding(start = 8.dp))
                CustomDivider(Modifier.weight(0.8f))
                Icon(
                    imageVector = if (expanded.value) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
            AnimatedVisibility(expanded.value) {
                expandContent()
            }
        }
    }
}