package com.example.tarjetacumple

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MarcoFestivo(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D1B69))
            .border(8.dp, Color(0xFFFFD700))
            .padding(6.dp)
            .border(3.dp, Color(0xFFFFFFFF).copy(alpha = 0.3f))
            .padding(16.dp)
    ) {
        content()

        // Esquinas
        Text("🎉", fontSize = 32.sp, modifier = Modifier.align(Alignment.TopStart))
        Text("🎊", fontSize = 32.sp, modifier = Modifier.align(Alignment.TopEnd))
        Text("🎈", fontSize = 32.sp, modifier = Modifier.align(Alignment.BottomStart))
        Text("🌟", fontSize = 32.sp, modifier = Modifier.align(Alignment.BottomEnd))
    }
}