package com.example.piedrapapeltijera.model


fun Move.toEmoji(): String {
    return when (this) {
        Move.ROCK -> "🪨"
        Move.PAPER -> "📄"
        Move.SCISSORS -> "✂️"
    }
}

fun getRoundResult(player: Move, ai: Move): GameResult {
    return when {
        player == ai -> GameResult.DRAW
        (player == Move.ROCK && ai == Move.SCISSORS) ||
                (player == Move.PAPER && ai == Move.ROCK) ||
                (player == Move.SCISSORS && ai == Move.PAPER) -> GameResult.WIN
        else -> GameResult.LOSE
    }
}

