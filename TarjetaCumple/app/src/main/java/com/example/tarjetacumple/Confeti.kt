package com.example.tarjetacumple


data class Confeti(
    val emoji: String,
    val posX: Float,
    val delay: Int,
    val velocidad: Int = (2000..5000).random()
)