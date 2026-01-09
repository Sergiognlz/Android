package com.example.loteria.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun ResultView(
    number: Int,
    apuesta: Int,
    navController: NavController,
    saldoInicial: Int = 10
) {
    var saldo by remember { mutableStateOf(saldoInicial) }

    val numeroGanador = remember { Random.nextInt(1, 10) }

    val gano = number == numeroGanador

    // Actualizamos saldo tras el resultado
    LaunchedEffect(Unit) {
        saldo = if (gano) saldo + apuesta * 2 else saldo - apuesta
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Número ganador: $numeroGanador",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = if (gano) "¡Ganaste!" else "¡Perdiste!",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Saldo actual: $saldo créditos",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón “Jugar de nuevo” → desactivado si saldo = 0
        Button(
            onClick = {
                navController.navigate("election/$saldo") {
                    popUpTo("election") { inclusive = true }
                }
            },
            enabled = saldo > 0, // aquí desactivamos si saldo = 0
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Jugar de nuevo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón “Salir” → siempre habilitado
        Button(
            onClick = {
                navController.navigate("election/10") {
                    popUpTo("election") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Salir")
        }
    }
}
