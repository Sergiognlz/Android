package com.example.piedrapapeltijera.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // Título grande: marcador, resultado
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize   = 56.sp,
        letterSpacing = (-1).sp
    ),
    // Subtítulos: "Elige tu jugada", "Resultado"
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize   = 22.sp,
        letterSpacing = 0.sp
    ),
    // Etiquetas pequeñas: "Tú", "CPU"
    labelMedium = TextStyle(
        fontWeight    = FontWeight.SemiBold,
        fontSize      = 13.sp,
        letterSpacing = 1.5.sp
    ),
    // Texto general
    bodyLarge = TextStyle(
        fontFamily    = FontFamily.Default,
        fontWeight    = FontWeight.Normal,
        fontSize      = 16.sp,
        lineHeight    = 24.sp,
        letterSpacing = 0.5.sp
    )
)