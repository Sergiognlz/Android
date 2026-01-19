package com.example.piedrapapeltijera.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(
    onStartGame: (playerName: String, totalRounds: Int) -> Unit,
    onViewHistory: () -> Unit // ✅ Nuevo callback
) {
    var playerName by remember { mutableStateOf("") }
    var selectedRounds by remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido al juego", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = playerName,
            onValueChange = { playerName = it },
            label = { Text("Nombre del jugador") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("Selecciona el número de rondas:", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = { selectedRounds = 3 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedRounds == 3) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            ) { Text("3") }

            Button(
                onClick = { selectedRounds = 5 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedRounds == 5) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            ) { Text("5") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (playerName.isNotBlank()) {
                    onStartGame(playerName, selectedRounds)
                }
            },
            enabled = playerName.isNotBlank()
        ) { Text("Empezar Juego") }

        Spacer(modifier = Modifier.height(16.dp))

        // ✅ Botón para historial
        Button(onClick = onViewHistory) {
            Text("Ver Historial")
        }
    }
}
