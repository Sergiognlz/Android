package com.example.listacontactos.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.listacontactos.data.Contacto

@Composable
fun ListaContactos(listaContactos:List<Contacto>, modifier : Modifier= Modifier){

    LazyColumn(modifier = modifier.fillMaxSize().padding(10.dp)) {
    items(listaContactos) { contacto->
        Tarjeta(contacto)
    }
    }

}