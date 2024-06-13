package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.R

@Composable
fun PkDimensionsRow(height: String, weight: String, modifier: Modifier = Modifier) {
    CustomRow(modifier) {
        OutlinedTextField(
            value = height,
            onValueChange = {},
            modifier = Modifier.width(120.dp),
            readOnly = true,
            label = { Text(text = stringResource(id = R.string.height)) },
            suffix = { Text(text = stringResource(id = R.string.ft)) }
        )
        Spacer(modifier = Modifier.width(40.dp))
        OutlinedTextField(
            value = weight,
            onValueChange = {},
            modifier = Modifier.width(120.dp),
            readOnly = true,
            label = { Text(text = stringResource(id = R.string.weight)) },
            suffix = { Text(text = stringResource(id = R.string.lbs)) }
        )
    }
}