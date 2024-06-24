package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.example.pokedex.ui.jet_comp.PkText

@Composable
fun ExpandableBox(
    headTitle: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val expanded = remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .clickable { expanded.value = expanded.value.not() }
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(10)
            )
            .padding(4.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            ExpandableBoxTitle(
                headTitle = headTitle,
                expandedValue = expanded.value
            )
            AnimatedVisibility(expanded.value) {
                content()
            }
        }
    }
}

@Composable
private fun ExpandableBoxTitle(
    headTitle: String,
    modifier: Modifier = Modifier,
    expandedValue: Boolean,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        PkText(
            text = headTitle,
            modifier = Modifier.padding(start = 8.dp)
        )
        CustomDivider(Modifier.weight(0.8f))
        Icon(
            imageVector = if (expandedValue) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
    }
}