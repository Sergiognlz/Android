package com.example.tarjetacumple

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ItemConfeti(confeti: Confeti) {
    val posY = remember { Animatable(-50f) }

    LaunchedEffect(Unit) {
        delay(confeti.delay.toLong())
        while (true) {
            posY.snapTo(-50f)
            posY.animateTo(
                targetValue = 2000f,
                animationSpec = tween(confeti.velocidad, easing = LinearEasing)
            )
        }
    }

    Text(
        text = confeti.emoji,
        fontSize = 24.sp,
        modifier = Modifier.offset(
            x = confeti.posX.dp,
            y = posY.value.dp
        )
    )
}