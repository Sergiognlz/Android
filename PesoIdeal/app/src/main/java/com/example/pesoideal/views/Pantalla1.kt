package com.example.pesoideal.views

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

    var nombre: String by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Calcular peso ideal",
            style = MaterialTheme.typography.headlineLarge,
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Nombre usuario
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(0.5f),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Peso usuario
        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.5f),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val nombre = nombre;
                val peso = peso.toDoubleOrNull() ?: 0.0
                val sexo="Hombre"
                navController.navigate("Pantalla2/$nombre/$peso/$sexo")
            },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("Hombre", style = MaterialTheme.typography.headlineMedium)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val nombre = nombre;
                val peso = peso.toDoubleOrNull() ?: 0.0
                val sexo="Mujer"
                navController.navigate("Pantalla2/$nombre/$peso/$sexo")
            },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("Mujer", style = MaterialTheme.typography.headlineMedium)
        }
    }
}