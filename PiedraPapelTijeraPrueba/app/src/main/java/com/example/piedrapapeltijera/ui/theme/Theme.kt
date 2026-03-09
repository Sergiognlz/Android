package com.example.piedrapapeltijera.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val GameColorScheme = darkColorScheme(
    primary       = PrimaryViolet,
    secondary     = SecondaryBlue,
    background    = BackgroundDark,
    surface       = SurfaceDark,
    onPrimary     = TextPrimary,
    onBackground  = TextPrimary,
    onSurface     = TextPrimary,
)

@Composable
fun PiedraPapelTijeraTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = GameColorScheme,
        typography  = Typography,
        content     = content
    )
}