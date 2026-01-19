package com.example.piedrapapeltijera.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piedrapapeltijera.model.Move
import com.example.piedrapapeltijera.model.toEmoji
import com.example.piedrapapeltijera.ui.components.GameButton
import com.example.piedrapapeltijera.viewmodels.GameViewModel


@Composable
fun GameScreen(gameViewModel: GameViewModel, onGameFinished: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // Parte superior: IA
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(gameViewModel.aiName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Puntos: ${gameViewModel.aiScore}")
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("🪨", fontSize = 32.sp)
                    Text("📄", fontSize = 32.sp)
                    Text("✂️", fontSize = 32.sp)
                }
            }
        }

        // Parte central: Resultado
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Resultado", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Tú: ${gameViewModel.playerMove?.toEmoji() ?: "❓"}", fontSize = 30.sp)
                Text("IA: ${gameViewModel.aiMove?.toEmoji() ?: "❓"}", fontSize = 30.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(gameViewModel.resultText, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Parte inferior: Jugador
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(gameViewModel.playerName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Puntos: ${gameViewModel.playerScore}")
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    GameButton("🪨") {
                        gameViewModel.play(Move.ROCK)
                        if (gameViewModel.isGameOver()) onGameFinished(gameViewModel.getWinner())
                    }
                    GameButton("📄") {
                        gameViewModel.play(Move.PAPER)
                        if (gameViewModel.isGameOver()) onGameFinished(gameViewModel.getWinner())
                    }
                    GameButton("✂️") {
                        gameViewModel.play(Move.SCISSORS)
                        if (gameViewModel.isGameOver()) onGameFinished(gameViewModel.getWinner())
                    }
                    GameButton("🎲") {
                        gameViewModel.play(Move.values().random())
                        if (gameViewModel.isGameOver()) onGameFinished(gameViewModel.getWinner())
                    }
                }
            }
        }
    }
}
