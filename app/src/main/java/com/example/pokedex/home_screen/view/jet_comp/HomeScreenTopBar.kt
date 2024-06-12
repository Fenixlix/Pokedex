package com.example.pokedex.home_screen.view.jet_comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex.R

@Composable
fun HomeScreenTopBar(modifier: Modifier = Modifier, onSearchClick: (String) -> Unit) {

    var searchWord by remember { mutableStateOf("") }
    val enabler = remember { derivedStateOf { searchWord.isNotEmpty() } }

    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchWord,
            onValueChange = { searchWord = it },
            modifier = Modifier
                .width(200.dp)
                .padding(4.dp),
            placeholder = { Text(text = stringResource(id = R.string.top_bar_placeholder)) },
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            keyboardActions = KeyboardActions(onSearch = {
                if (enabler.value) onSearchClick(
                    searchWord
                )
            })
        )
        IconButton(enabled = enabler.value, onClick = { onSearchClick(searchWord) }) {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
        }
    }
}