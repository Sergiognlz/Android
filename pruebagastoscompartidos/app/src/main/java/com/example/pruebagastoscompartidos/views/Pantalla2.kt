package com.example.pruebagastoscompartidos.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

object ListaGastos {
    val personas = mutableListOf<Pair<String, Double>>()
}

@Composable
fun Pantalla2(navController: NavController, numPersonas: Int, total: Double) {

    val nombres = remember { List(numPersonas) { mutableStateOf("") } }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(nombres) { index, nombre ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Persona ${index + 1}")
                    TextField(
                        value = nombre.value,
                        onValueChange = { nombre.value = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth(0.6f)
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(100.dp)) }
        }

        Button(
            onClick = {
                val gastoIndividual = if (numPersonas > 0) total / numPersonas else 0.0
                ListaGastos.personas.clear()
                nombres.forEach { nombre ->
                    ListaGastos.personas.add(nombre.value to gastoIndividual)
                }
                navController.navigate("Pantalla3")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
        ) {
            Text("Continuar")
        }
    }
}
