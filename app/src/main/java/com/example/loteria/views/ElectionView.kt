package com.example.loteria.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ElectionView(navController: NavController, saldoActual: Int = 10) {

    // Creamos lista de botones del 1 al 9
    val botones = List(9) { index -> (index + 1).toString() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Título grande y centrado
        Text(
            text = "Juego de la Lotería",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 52.dp, bottom = 24.dp)
        )

        // Grid de botones centrado
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(botones) { texto ->
                    val number = texto.toInt()
                    ElectionButton(
                        number = number,
                        navController = navController,
                        saldoActual = saldoActual
                    )
                }
            }
        }
    }
}

@Composable
fun ElectionButton(number: Int, navController: NavController, saldoActual: Int) {
    Button(
        onClick = {
            // Navegamos a ApuestaView pasando número y saldo actual
            navController.navigate("apuesta/$number/$saldoActual")
        },
        modifier = Modifier
            .aspectRatio(1f) // cuadrado perfecto
            .fillMaxWidth()
    ) {
        Text(
            text = number.toString(),
            fontSize = 20.sp
        )
    }
}
