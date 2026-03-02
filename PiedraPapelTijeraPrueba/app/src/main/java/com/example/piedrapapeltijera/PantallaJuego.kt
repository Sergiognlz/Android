package com.example.piedrapapeltijera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PantallaJuego(){

    var eleccionJugador by remember { mutableStateOf("") }
    var eleccionMaquina by remember{mutableStateOf("")}
    var mostrarDialog by remember { mutableStateOf(false) }
    var mensajeDialog by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        SeccionMaquina(
            eleccionMaquina = eleccionMaquina,
            jugadorEligio = eleccionJugador != ""
        )

        SeccionJugador { eleccion ->
            eleccionJugador = eleccion  // actualiza el estado de la pantalla principal
            eleccionMaquina = listOf("✊","✋","✌️").random()
            mensajeDialog = determinarGanador(eleccionJugador, eleccionMaquina)
            mostrarDialog = true
        }
        if (mostrarDialog) {
            AlertDialog(
                onDismissRequest = { mostrarDialog = false },
                title = { Text("Resultado") },
                text = { Text(mensajeDialog) },
                confirmButton = {
                    Button(onClick = {
                        // Reiniciar estados
                        eleccionJugador = ""
                        eleccionMaquina = ""
                        mostrarDialog = false
                    }) {
                        Text("Jugar otra vez")
                    }
                }
            )
        }
    }
}