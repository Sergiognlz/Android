package com.example.loteria.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ApuestaView(
    number: Int,
    navController: NavController,
    saldoInicial: Int = 10  // saldo que recibe desde ElectionView o ResultadoView
) {
    // Estado del saldo actual
    var saldo by remember { mutableStateOf(saldoInicial) }

    // Estado de la apuesta introducida por el usuario
    var apuestaText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Número elegido
        Text(
            text = "Número elegido: $number",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Saldo actual
        Text(
            text = "Saldo actual: $saldo créditos",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Input para apostar
        OutlinedTextField(
            value = apuestaText,
            onValueChange = { input ->
                val numero = input.toIntOrNull()
                apuestaText = when {
                    numero == null || numero < 1 -> ""
                    numero > saldo -> saldo.toString()
                    else -> input
                }
            },
            label = { Text("Cantidad a apostar") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.5f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón “Apostar”
        Button(
            onClick = {
                val apuesta = apuestaText.toIntOrNull() ?: 0
                if (apuesta in 1..saldo) {
                    // Navegamos a ResultadoView pasando número, apuesta y saldo actual
                    navController.navigate("resultado/$number/$apuesta/$saldo")
                }
            },
            enabled = run {
                val apuesta = apuestaText.toIntOrNull() ?: 0
                apuesta in 1..saldo
            },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("Apostar")
        }
    }
}
