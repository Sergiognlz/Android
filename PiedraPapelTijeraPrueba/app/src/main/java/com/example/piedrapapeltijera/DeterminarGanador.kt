package com.example.piedrapapeltijera

fun determinarGanador(jugador: String, maquina: String): String {
    return if (jugador == maquina) {
        "Empate"
    } else if ((jugador == "✊" && maquina == "✌️") ||
        (jugador == "✋" && maquina == "✊") ||
        (jugador == "✌️" && maquina == "✋")) {
        "Has ganado"
    } else {
        "Has perdido"
    }
}