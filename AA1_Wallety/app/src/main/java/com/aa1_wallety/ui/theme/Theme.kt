package com.aa1_wallety.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    secondary = GreenIncome,
    tertiary = GreenBackground,
    background = White,
    surface = White,
    onPrimary = White,
    onBackground = GrayDark,
    onSurface = GrayDark
)

@Composable
fun Aa1_walletyTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}