package com.example.loteria.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.loteria.views.ApuestaView
import com.example.loteria.views.ElectionView
import com.example.loteria.views.ResultView

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "election/{saldo}",
        builder = {
            // Pantalla 1: ElectionView
            composable(
                route = "election/{saldo}",
                arguments = listOf(
                    navArgument("saldo") { type = NavType.IntType; defaultValue = 10 }
                )
            ) { backStackEntry ->
                val saldoActual = backStackEntry.arguments?.getInt("saldo") ?: 10
                ElectionView(navController = navController, saldoActual = saldoActual)
            }

            // Pantalla 2: ApuestaView
            composable(
                route = "apuesta/{number}/{saldo}",
                arguments = listOf(
                    navArgument("number") { type = NavType.IntType },
                    navArgument("saldo") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val number = backStackEntry.arguments?.getInt("number") ?: 0
                val saldoActual = backStackEntry.arguments?.getInt("saldo") ?: 10
                ApuestaView(number = number, navController = navController, saldoInicial = saldoActual)
            }

            // Pantalla 3: ResultView
            composable(
                route = "resultado/{number}/{apuesta}/{saldo}",
                arguments = listOf(
                    navArgument("number") { type = NavType.IntType },
                    navArgument("apuesta") { type = NavType.IntType },
                    navArgument("saldo") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val number = backStackEntry.arguments?.getInt("number") ?: 0
                val apuesta = backStackEntry.arguments?.getInt("apuesta") ?: 0
                val saldoActual = backStackEntry.arguments?.getInt("saldo") ?: 10

                ResultView(
                    number = number,
                    apuesta = apuesta,
                    navController = navController,
                    saldoInicial = saldoActual
                )
            }
        }
    )
}
