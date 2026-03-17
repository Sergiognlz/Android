package com.example.loginusuario

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaLogin(modifier: Modifier = Modifier) {
    var usuario by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var hayError by remember { mutableStateOf(false) }
    var loginExitoso by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TituloLogin()
        Spacer(modifier = Modifier.height(32.dp))
        CampoUsuario(usuario = usuario, hayError = hayError, onValueChange = { usuario = it })
        Spacer(modifier = Modifier.height(16.dp))
        CampoPassword(password = password, hayError = hayError, onValueChange = { password = it })
        if (hayError) {
            MensajeError()
        }
        Spacer(modifier = Modifier.height(24.dp))
        BotonEntrar(onClick = {
            if (usuario == "Sergio" && password == "1234") {
                loginExitoso = true
            } else {
                hayError = true
            }
        })
    }

    if (loginExitoso) {
        DialogBienvenida(
            usuario = usuario,
            onAceptar = { loginExitoso = false }
        )
    }
}

@Composable
fun TituloLogin() {
    Text(
        text = "Iniciar sesion",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun CampoUsuario(usuario: String, hayError: Boolean, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = usuario,
        onValueChange = onValueChange,
        label = { Text("Usuario") },
        leadingIcon = { Icon(Icons.Default.Person, "") },
        isError = hayError,
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CampoPassword(password: String, hayError: Boolean, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = onValueChange,
        label = { Text("Contrasena") },
        leadingIcon = { Icon(Icons.Default.Lock, "") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        isError = hayError,
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MensajeError() {
    Text(
        text = "Usuario o contrasena incorrectos",
        color = Color.Red,
        fontSize = 13.sp
    )
}

@Composable
fun BotonEntrar(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Entrar")
    }
}

@Composable
fun DialogBienvenida(usuario: String, onAceptar: () -> Unit) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text("Bienvenido") },
        text = { Text("Hola $usuario, has iniciado sesion correctamente") },
        confirmButton = {
            Button(onClick = onAceptar) {
                Text("Aceptar")
            }
        }
    )
}