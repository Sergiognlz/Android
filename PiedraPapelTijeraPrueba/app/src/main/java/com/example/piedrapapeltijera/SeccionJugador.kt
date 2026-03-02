package com.example.piedrapapeltijera

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SeccionJugador(onSeleccion: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
                .clickable {
                    onSeleccion("✊")   // <-- aquí llamamos al callback
                },
            contentAlignment = Alignment.Center
        ) {
            Text("✊",fontSize = 40.sp)
        }
        Spacer(modifier = Modifier.weight(16f))

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Gray)
            .clickable{
                onSeleccion("✋")
            }
            .background(Color.Gray),
            contentAlignment = Alignment.Center
        ){
            Text("✋",fontSize = 40.sp)
        }

        Spacer(modifier = Modifier.weight(16f))

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Gray)
            .clickable{
                onSeleccion("✌️")
            }
            .background(Color.Gray),
            contentAlignment = Alignment.Center
        ){
            Text(text="✌️",fontSize = 40.sp)
        }
    }
}