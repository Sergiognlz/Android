package com.example.piedrapapeltijera.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.piedrapapeltijera.data.repositories.MatchRepository
import com.example.piedrapapeltijera.model.MatchModel
import com.example.piedrapapeltijera.model.Move
import kotlinx.coroutines.launch

class GameViewModel(private val repository: MatchRepository? = null) : ViewModel() {

    var playerName by mutableStateOf("")
    var playerScore by mutableStateOf(0)
    var aiScore by mutableStateOf(0)
    var round by mutableStateOf(1)
    var totalRounds = 3

    var playerMove: Move? by mutableStateOf(null)
    var aiMove: Move? by mutableStateOf(null)
    var resultText by mutableStateOf("")

    val aiName = "IA"

    fun resetGame() {
        playerScore = 0
        aiScore = 0
        round = 1
        playerMove = null
        aiMove = null
        resultText = ""
    }

    fun play(move: Move) {
        playerMove = move
        aiMove = Move.values().random()

        resultText = when {
            playerMove == aiMove -> "Empate"
            playerMove == Move.ROCK && aiMove == Move.SCISSORS -> "Gana"
            playerMove == Move.PAPER && aiMove == Move.ROCK -> "Gana"
            playerMove == Move.SCISSORS && aiMove == Move.PAPER -> "Gana"
            else -> "Pierde"
        }

        when (resultText) {
            "Gana" -> playerScore++
            "Pierde" -> aiScore++
        }

        round++
    }

    fun isGameOver(): Boolean = round > totalRounds

    fun getWinner(): String = when {
        playerScore > aiScore -> playerName
        aiScore > playerScore -> aiName
        else -> "Empate"
    }

    // Guardar partida en Room
    fun saveMatch(format: String) {
        repository?.let {
            viewModelScope.launch {
                it.insertMatch(
                    MatchModel(
                        playerName = playerName,
                        aiName = aiName,
                        format = format,
                        playerScore = playerScore,
                        aiScore = aiScore,
                        winner = getWinner()
                    )
                )
            }
        }
    }
}
