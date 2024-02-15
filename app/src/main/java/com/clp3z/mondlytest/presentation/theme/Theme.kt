package com.clp3z.mondlytest.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val DarkColorPalette = darkColors(
    primary = darkPrimaryColor,
    secondary = darkSecondaryColor,
    onSecondary = darkOnSecondaryColor,
    background = darkBackgroundColor
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    secondary = secondaryColor,
    onSecondary = onSecondaryColor,
    background = backgroundColor
)

@Composable
fun MondlyTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = if (darkTheme) Color.Black.toArgb() else primaryColor.toArgb()
        }
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
