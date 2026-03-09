package com.example.tarjetacumple

import androidx.compose.material3.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable

fun PantallaInicio(navController: NavHostController) {
    MarcoFestivo {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFF2D1B69)),  // morado oscuro
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Button(
                onClick = { navController.navigate("felicitacion") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFD700),  // dorado
                    contentColor = Color(0xFF2D1B69)     // morado oscuro para el texto
                )
            ) {
                Text(
                    text = "¡Púlsame!",
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                    text = "Una sorpresa te espera... \uD83C\uDF81",
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp),
                fontSize = 16.sp,
                color = Color(0xFFE2E8F0)

            )
        }
    }
}