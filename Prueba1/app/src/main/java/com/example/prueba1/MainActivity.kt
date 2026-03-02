package com.example.prueba1

import android.R
import android.R.attr.text
import android.os.Bundle
import android.renderscript.Sampler
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prueba1.ui.theme.Prueba1Theme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prueba1Theme {
                MiApp()
                }
            }
        }
    }


@Composable
fun MiApp() {

    var nombre by remember{mutableStateOf("")}
    var saludo by remember { mutableStateOf("") } // inicial vacío

    Column(Modifier
        .fillMaxSize()
        .padding(24.dp)

    ) {
        TextField(
            value = nombre,
            onValueChange = { nuevoValor ->
                nombre = nuevoValor

            },
            label ={Text("Escribe aquí tu nombre")},
            singleLine = true,
            modifier= Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { saludo="Hola $nombre" },
        enabled = nombre.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Saludar")
        }
        Spacer(modifier=Modifier.height(16.dp))

        Text(
            text=saludo,
            color=if(saludo.isNotBlank()) Color.Red else Color.Gray,
            style = MaterialTheme.typography.headlineSmall

        )
    }
}