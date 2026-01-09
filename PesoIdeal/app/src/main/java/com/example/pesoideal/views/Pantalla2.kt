package com.example.pesoideal.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Pantalla2(nombre: String?, peso: Double, sexo: String?, navController: NavController) {

    var selectedAltura by remember { mutableStateOf<Int?>(null) }
    val alturas = (150..220).toList()   // Lista de alturas



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Nombre: $nombre",
            style = MaterialTheme.typography.headlineLarge,
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Peso: $peso",
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Sexo: $sexo",
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Seleccione altura",
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(20.dp))

        // 🔽 Lista scrollable de alturas
        LazyColumn(
            modifier = Modifier
                .height(200.dp) // para que sea scrollable
                .fillMaxWidth()
        ) {
            items(alturas) { altura ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedAltura = altura }
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "$altura cm", style = MaterialTheme.typography.headlineMedium)

                    // Indicador del seleccionado
                    if (selectedAltura == altura) {
                        Text(text = "✔", style = MaterialTheme.typography.headlineMedium)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón continuar solo si hay altura seleccionada
        Button(
            onClick = {
                // Lógica siguiente pantalla aquí
                navController.navigate("Pantalla3/$peso/$sexo/$selectedAltura")
            },
            enabled = selectedAltura != null
        ) {
            Text("Continuar (${selectedAltura ?: "--"} cm)")
    }


    }
}
