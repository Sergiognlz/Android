

import com.example.pruebagastoscompartidos.views.Pantalla1
import com.example.pruebagastoscompartidos.views.Pantalla2
import com.example.pruebagastoscompartidos.views.Pantalla3


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaGastosCompartidosTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "Pantalla1"
                    ) {
                        // Pantalla 1
                        composable("Pantalla1") {
                            Pantalla1(navController = navController)
                        }

                        // Pantalla 2
                        composable(
                            "Pantalla2/{numPersonas}/{total}"
                        ) { backStackEntry ->
                            val numPersonas = backStackEntry.arguments
                                ?.getString("numPersonas")?.toIntOrNull() ?: 0
                            val total = backStackEntry.arguments
                                ?.getString("total")?.toDoubleOrNull() ?: 10.0
                            Pantalla2(
                                navController = navController,
                                numPersonas = numPersonas,
                                total = total
                            )
                        }

                        // Pantalla 3 → no recibe la lista por parámetro
                        composable("Pantalla3") {
                            Pantalla3(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
