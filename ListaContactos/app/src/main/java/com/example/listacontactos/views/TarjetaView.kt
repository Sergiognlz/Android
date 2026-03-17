package com.example.listacontactos.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.CardDefaults
import com.example.listacontactos.data.Contacto

@Composable

fun Tarjeta(contacto: Contacto) {
    Card(modifier = Modifier.fillMaxWidth().padding(2.dp),
       colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(painterResource(id = contacto.foto),
                contentDescription = "FotoContacto",
                modifier = Modifier.size(60.dp))

            Spacer(modifier = Modifier.padding(16.dp))

            Column() {
                Text(text=contacto.nombre,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                    )
                Text(contacto.telefono)
            }

        }
    }
}