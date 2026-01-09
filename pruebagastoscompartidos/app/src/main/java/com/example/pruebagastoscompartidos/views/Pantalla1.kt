package com.example.pruebagastoscompartidos.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Pantalla1(navController: NavController) {

    var numPersonas by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Gastos Compartidos",
            style = MaterialTheme.typography.headlineLarge,
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Número de personas
        OutlinedTextField(
            value = numPersonas,
            onValueChange = { numPersonas = it },
            label = { Text("Número de personas") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.5f),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Total
        OutlinedTextField(
            value = total,
            onValueChange = { total = it },
            label = { Text("Total del gasto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.5f),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val num = numPersonas.toIntOrNull() ?: 1
                val totalDouble = total.toDoubleOrNull() ?: 0.0
                navController.navigate("Pantalla2/$num/$totalDouble")
            },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("Calcular", style = MaterialTheme.typography.headlineMedium)
        }
    }
}
