package com.example.pokedex.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = RedD,
    secondary = BlueD,
    tertiary = GreenD,
    background = SurfBackGroundD,
    surface = SurfBackGroundD,
    onPrimary = OnPrimSecTerD,
    onSecondary = OnPrimSecTerD,
    onTertiary = OnPrimSecTerD,
    onBackground = SurfBackGroundL,
    onSurface = SurfBackGroundL
)

private val LightColorScheme = lightColorScheme(
    primary = RedL,
    secondary = BlueL,
    tertiary = GreenL,
    background = SurfBackGroundL,
    surface = SurfBackGroundL,
    onPrimary = OnPrimSecTerL,
    onSecondary = OnPrimSecTerL,
    onTertiary = OnPrimSecTerL,
    onBackground = SurfBackGroundD,
    onSurface = SurfBackGroundD
)

@Composable
fun PokedexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}