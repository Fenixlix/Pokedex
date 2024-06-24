package com.example.pokedex.detail_screen.view.jet_comp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex.detail_screen.model.PkTypeList

@Composable
fun PkTypesRow(pkTypeList: List<PkTypeList>, modifier: Modifier = Modifier) {
    CustomRow(modifier) {
        pkTypeList.forEach {
            TypeContainer(type = it)
        }
    }
}


@Composable
private fun TypeContainer(type: PkTypeList, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .height(40.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(25)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = type.image),
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop,
            contentDescription = type.typeName
        )
        Text(
            text = type.typeName.uppercase(),
            modifier = Modifier
                .width(100.dp)
                .padding(4.dp),
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = type.textColor),
            textAlign = TextAlign.Center
        )
    }
}