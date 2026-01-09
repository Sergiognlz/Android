package com.example.pruebagastoscompartidos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebagastoscompartidos.ui.theme.PruebagastoscompartidosTheme
import com.example.pruebagastoscompartidos.views.Pantalla1
import com.example.pruebagastoscompartidos.views.Pantalla2
import com.example.pruebagastoscompartidos.views.Pantalla3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebagastoscompartidosTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "Pantalla1"
                    ) {

                        composable("Pantalla1") {
                            Pantalla1(navController)
                        }

                        composable("Pantalla2/{numPersonas}/{total}") { backStackEntry ->
                            val numPersonas = backStackEntry.arguments
                                ?.getString("numPersonas")?.toIntOrNull() ?: 1
                            val total = backStackEntry.arguments
                                ?.getString("total")?.toDoubleOrNull() ?: 0.0

                            Pantalla2(navController, numPersonas, total)
                        }

                        composable("Pantalla3") {
                            Pantalla3(navController)
                        }
                    }
                }
            }
        }
    }
}
