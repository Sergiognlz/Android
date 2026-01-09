package com.example.pesoideal.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.math.pow

@Composable
fun Pantalla3(peso: Double, sexo: String?, selectedAltura: Double, navController: NavController) {

    val coeficiente = if (sexo == "Hombre") 1.0 else 0.9
    //ponemos la altura en metros
    val alturaMetros = selectedAltura / 100.0
    //calculamos el IMC (peso/altura*altura)*coeficiente
    val IMC = (peso / alturaMetros.pow(2)) * coeficiente

    val resultado = when  {
     IMC<18.5 -> "Bajo peso"
        IMC in 18.5..24.9 -> "Peso medio"
        IMC in 25.0..29.9 ->"Sobrepeso"
        IMC>=30 ->"Obesidad"
        else ->"El peso introducido no es correcto"


    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Resultados: $resultado",
            style = MaterialTheme.typography.headlineLarge,
        )

        Button(
            onClick = {
                // Lógica siguiente pantalla aquí
                navController.navigate("Pantalla1")
            }
        ) {
            Text("Volver")
        }


}
}