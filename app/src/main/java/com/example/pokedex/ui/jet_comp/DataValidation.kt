package com.example.pokedex.ui.jet_comp

import androidx.compose.runtime.Composable

@Composable
fun DataValidation(isLoading: Boolean, hasEmptyData: Boolean, screen: @Composable () -> Unit) {
    if (isLoading) {
        LoadingBox()
    } else if (hasEmptyData) {
        ErrorMessage()
    } else {
        screen()
    }
}