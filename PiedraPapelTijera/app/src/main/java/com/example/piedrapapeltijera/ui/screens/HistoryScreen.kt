package com.example.piedrapapeltijera.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piedrapapeltijera.data.repositories.MatchRepository
import com.example.piedrapapeltijera.model.MatchModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun HistoryScreen(repository: MatchRepository?, onBack: () -> Unit) {

    val matchesFlow: Flow<List<MatchModel>> = repository?.getAllMatches() ?: emptyFlow()
    val matches by matchesFlow.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Historial de partidas", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(matches) { match ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Jugador: ${match.playerName}")
                        Text("IA: ${match.aiName}")
                        Text("Formato: ${match.format}")
                        Text("Resultado: ${match.playerScore} - ${match.aiScore} → Ganador: ${match.winner}")
                        Text("Fecha: ${java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(match.timestamp)}")
                    }
                }
            }
        }
    }
}
