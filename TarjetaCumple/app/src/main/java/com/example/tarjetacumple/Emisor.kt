package com.example.tarjetacumple

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Emisor(modifier: Modifier= Modifier){
    Text(
        text = "de Sergio que te quiere ❤\uFE0F",
        fontSize = 20.sp,
        textAlign = TextAlign.End,
        modifier=modifier,
        color = Color(0xFFE2E8F0)  // blanco suave
    )
}