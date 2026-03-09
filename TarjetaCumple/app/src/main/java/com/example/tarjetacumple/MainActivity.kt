package com.example.tarjetacumple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tarjetacumple.ui.theme.TarjetaCumpleañosTheme
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.core.tween


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TarjetaCumpleañosTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "inicio") {
                    composable("inicio") { PantallaInicio(navController) }
                    composable(
                        "felicitacion",
                        enterTransition = {
                            slideInVertically(
                                initialOffsetY = { it },
                                animationSpec = tween(600)
                            )
                        }
                    ) { PantallaFelicitacion() }
                }

            }
        }
    }
}

