package com.example.pokedex.ui.jet_comp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DataValidation(
    isLoading: Boolean,
    hasEmptyData: Boolean,
    screen: @Composable () -> Unit
) {
    when {
        hasEmptyData && isLoading -> LoadingBox()

        !hasEmptyData && isLoading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                screen()
                LoadingBox()
            }
        }

        !hasEmptyData && !isLoading -> screen()
        else -> ErrorMessage()
    }
}