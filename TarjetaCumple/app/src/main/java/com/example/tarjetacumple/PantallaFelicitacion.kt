package com.example.tarjetacumple

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.tarjetacumple.R

@Composable
fun PantallaFelicitacion() {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.sonido_cumple)
        mediaPlayer.start()
    }

    MarcoFestivo {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFF2D1B69)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Felicitar()
            Spacer(modifier = Modifier.height(16.dp))
            Emisor()
        }
        ConfetiAnimado()
    }
}