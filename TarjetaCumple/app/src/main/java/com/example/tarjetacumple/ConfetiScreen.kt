package com.example.tarjetacumple


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun ConfetiAnimado() {

    val items = remember {
        val emojis = listOf("🎉", "🎊", "🎈", "🌟", "🎁", "✨", "🎀", "🍭", "🎂", "🪅")
        List(20) {
            Confeti(
                emoji = emojis.random(),
                posX = (0..350).random().toFloat(),
                delay = (0..3000).random()
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        items.forEach { confeti ->
            ItemConfeti(confeti)
        }
    }
}