package com.example.piedrapapeltijera

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun SeccionMaquina(eleccionMaquina: String, jugadorEligio: Boolean) {
    // Si el jugador no ha elegido todavía, no mostramos nada o mostramos un placeholder
    if (jugadorEligio) {
        Text(
            text = "Máquina: $eleccionMaquina",
            fontSize = 30.sp
        )
    } else {
        Text(
            text = "Máquina",
            fontSize = 30.sp
        )
    }
}