package com.example.pesoideal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pesoideal.ui.theme.PesoIdealTheme
import com.example.pesoideal.views.Pantalla1
import com.example.pesoideal.views.Pantalla2
import com.example.pesoideal.views.Pantalla3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PesoIdealTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "Pantalla1"
                    ) {

                        composable("Pantalla1") {
                            Pantalla1(navController)
                        }

                        composable("Pantalla2/{nombre}/{peso}/{sexo}") { backStackEntry ->
                            val nombre = backStackEntry.arguments
                                ?.getString("nombre")
                            val peso = backStackEntry.arguments
                                ?.getString("peso")?.toDoubleOrNull() ?: 0.0
                            val sexo= backStackEntry.arguments?.getString("sexo")

                            Pantalla2(nombre,peso,sexo,navController)
                        }

                        composable("Pantalla3/{peso}/{sexo}/{selectedAltura}") {backStackEntry ->
                            val peso = backStackEntry.arguments
                                ?.getString("peso")?.toDoubleOrNull() ?: 0.0
                            val sexo= backStackEntry.arguments?.getString("sexo")

                            val selectedAltura = backStackEntry.arguments
                                ?.getString("selectedAltura")?.toDoubleOrNull() ?: 0.0


                            Pantalla3(peso, sexo, selectedAltura, navController )
                        }
                    }
                }
            }
        }
    }
}

