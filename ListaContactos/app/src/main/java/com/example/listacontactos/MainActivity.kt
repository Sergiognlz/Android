package com.example.listacontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listacontactos.data.Contacto
import com.example.listacontactos.data.ListaContactos
import com.example.listacontactos.ui.theme.ListaContactosTheme
import com.example.listacontactos.views.ListaContactos
import com.example.listacontactos.views.Tarjeta

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaContactosTheme {
                Scaffold(topBar = {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF1565C0))
                                .padding(top = 40.dp, bottom = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Contactos",
                                color = Color.White,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                }
                ) { innerPadding ->
                    ListaContactos(ListaContactos, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

