package com.example.loginusuario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.loginusuario.PantallaLogin
import com.example.loginusuario.ui.theme.LoginUsuarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginUsuarioTheme{
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaLogin(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}