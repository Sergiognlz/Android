package com.example.listacontactos.data

import androidx.annotation.DrawableRes

data class Contacto(
    val id: Int,
    val nombre: String,
    val telefono: String,
    @DrawableRes val foto: Int
)



