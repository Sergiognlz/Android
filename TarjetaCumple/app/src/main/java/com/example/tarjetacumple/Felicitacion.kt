package com.example.tarjetacumple

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.tarjetacumple.ui.theme.fuenteCumpleaños

@Composable

fun Felicitar(modifier: Modifier= Modifier) {
    Text(
        text =("🎂 ¡Feliz Cumpleaños Maca! 🎉"),
        fontFamily = fuenteCumpleaños,
        fontSize = 60.sp,
        lineHeight = 60.sp,
        textAlign = TextAlign.Center,
        modifier = modifier,
        color = Color(0xFFFFD700)  // dorado
    )
}