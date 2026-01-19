package com.example.piedrapapeltijera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable

import androidx.room.Room
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.piedrapapeltijera.data.database.AppDatabase
import com.example.piedrapapeltijera.data.repositories.MatchRepository
import com.example.piedrapapeltijera.ui.screens.GameScreen
import com.example.piedrapapeltijera.ui.screens.HistoryScreen
import com.example.piedrapapeltijera.ui.screens.ResultScreen
import com.example.piedrapapeltijera.ui.screens.WelcomeScreen
import com.example.piedrapapeltijera.viewmodels.GameViewModel

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "matches.db").build()
    }

    private val repository by lazy { MatchRepository(db.matchDao()) }

    private val gameViewModel: GameViewModel by viewModels {
        object : androidx.lifecycle.ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return GameViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(gameViewModel, repository)
        }
    }
}

@Composable
fun AppNavigation(gameViewModel: GameViewModel, repository: MatchRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {

        // 🟢 Pantalla de bienvenida
        composable("welcome") {
            WelcomeScreen(
                onStartGame = { name, totalRounds ->
                    gameViewModel.playerName = name
                    gameViewModel.totalRounds = totalRounds
                    gameViewModel.resetGame()
                    navController.navigate("game")
                },
                onViewHistory = {
                    navController.navigate("history")
                }
            )
        }

        // 🟢 Pantalla de juego
        composable("game") {
            GameScreen(gameViewModel) { winner ->
                // Guardamos la partida
                gameViewModel.saveMatch("BO${gameViewModel.totalRounds}")
                navController.navigate("result/$winner")
            }
        }

        // 🟢 Pantalla de resultados con parámetro
        composable(
            "result/{winner}",
            arguments = listOf(navArgument("winner") { type = NavType.StringType })
        ) { backStackEntry ->
            val winner = backStackEntry.arguments?.getString("winner") ?: ""
            ResultScreen(
                winner = winner,
                onReplay = {
                    gameViewModel.resetGame()
                    navController.navigate("game")
                },
                onChangePlayer = {
                    gameViewModel.resetGame()
                    navController.navigate("welcome") {
                        popUpTo("welcome") { inclusive = true }
                    }
                }
            )
        }

        // 🟢 Pantalla de historial
        composable("history") {
            HistoryScreen(
                repository = repository,
                onBack = { navController.navigateUp() }
            )
        }
    }
}
