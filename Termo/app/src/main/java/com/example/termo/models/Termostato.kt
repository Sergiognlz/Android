package com.example.termo.models

// Solo guarda datos y lógica de negocio
data class Termostato(val temperatura: Int = 20)

object TermostatoRepository {
    private var termostato = Termostato()

    fun getTemperatura(): Int = termostato.temperatura
}