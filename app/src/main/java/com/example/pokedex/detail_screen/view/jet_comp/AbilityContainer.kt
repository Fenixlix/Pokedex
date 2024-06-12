package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.R
import com.example.pokedex.data.retrofit.responses.Ability

@Composable
fun AbilityContainer(ability: Ability, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = ability.ability.name.uppercase(),
            fontSize = 18.sp,
            modifier = Modifier.padding(4.dp)
        )
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.hidden_ability),
                modifier = Modifier.padding(4.dp)
            )
            if (ability.isHidden) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    tint = Color.Green,
                    contentDescription = null
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    tint = Color.Red,
                    contentDescription = null
                )
            }
        }
    }
}