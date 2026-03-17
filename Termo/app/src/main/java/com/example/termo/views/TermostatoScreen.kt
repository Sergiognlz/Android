package com.example.termo.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.termo.viewmodels.TermostatoViewModel

@Composable
fun TermostatoScreen(
    modifier: Modifier = Modifier,
    viewModel: TermostatoViewModel = viewModel()
) {
    val temperatura by viewModel.temperatura

    val arcColor by remember(temperatura) {
        derivedStateOf {
            when {
                temperatura <= 15 -> Color(0xFF378ADD)
                temperatura <= 20 -> Color(0xFF1D9E75)
                temperatura <= 25 -> Color(0xFFEF9F27)
                else              -> Color(0xFFE24B4A)
            }
        }
    }

    val statusInfo by remember(temperatura) {
        derivedStateOf {
            when {
                temperatura <= 14 -> Triple("MUY FRÍO",  Color(0xFFE6F1FB), Color(0xFF185FA5))
                temperatura <= 18 -> Triple("FRÍO",      Color(0xFFE6F1FB), Color(0xFF378ADD))
                temperatura <= 22 -> Triple("CONFORT",   Color(0xFFE1F5EE), Color(0xFF0F6E56))
                temperatura <= 26 -> Triple("CÁLIDO",    Color(0xFFFAEEDA), Color(0xFF854F0B))
                else              -> Triple("MUY CALIENTE", Color(0xFFFCEBEB), Color(0xFFA32D2D))
            }
        }
    }

    val animatedProgress by animateFloatAsState(
        targetValue = (temperatura - 10f) / 20f,
        animationSpec = tween(300),
        label = "arcProgress"
    )

    // Ocupa toda la pantalla, fondo suave
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F4F0))
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // ── Cabecera ──────────────────────────────────────────
        Text(
            text = "TERMOSTATO",
            fontSize = 12.sp,
            letterSpacing = 3.sp,
            color = Color(0xFF9E9D97),
            fontWeight = FontWeight.Medium
        )
        // ── Arco circular, ocupa el máximo posible ────────────
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        val arcSize = minOf(size.width, size.height)
                        val strokeWidth = arcSize * 0.06f
                        val padding = strokeWidth / 2
                        val offset = (size.width - arcSize) / 2
                        val arcRect = androidx.compose.ui.geometry.Rect(
                            Offset(offset + padding, padding),
                            Size(arcSize - strokeWidth, arcSize - strokeWidth)
                        )
                        val startAngle = 135f
                        val sweepTotal = 270f

                        drawArc(
                            color = Color(0xFFE8E7E2),
                            startAngle = startAngle,
                            sweepAngle = sweepTotal,
                            useCenter = false,
                            topLeft = arcRect.topLeft,
                            size = arcRect.size,
                            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                        )
                        drawArc(
                            color = arcColor,
                            startAngle = startAngle,
                            sweepAngle = sweepTotal * animatedProgress,
                            useCenter = false,
                            topLeft = arcRect.topLeft,
                            size = arcRect.size,
                            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$temperatura",
                        fontSize = 96.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF1A1A18),
                        lineHeight = 96.sp
                    )
                    Text(
                        text = "°C",
                        fontSize = 28.sp,
                        color = Color(0xFF888780),
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }

        // ── Controles inferiores ──────────────────────────────
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Min / Max flanqueando el slider
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("10°", fontSize = 13.sp, color = Color(0xFF9E9D97))
                Text("30°", fontSize = 13.sp, color = Color(0xFF9E9D97))
            }

            Slider(
                value = temperatura.toFloat(),
                onValueChange = { viewModel.setTemperatura(it.toInt()) },
                valueRange = 10f..30f,
                steps = 19,
                colors = SliderDefaults.colors(
                    thumbColor = arcColor,
                    activeTrackColor = arcColor,
                    inactiveTrackColor = Color(0xFFE8E7E2)
                ),
                modifier = Modifier.fillMaxWidth()
            )

            // Botones +/-
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = { if (temperatura > 10) viewModel.setTemperatura(temperatura - 1) },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF2C2C2A)
                    )
                ) {
                    Text("−", fontSize = 24.sp)
                }
                OutlinedButton(
                    onClick = { if (temperatura < 30) viewModel.setTemperatura(temperatura + 1) },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF2C2C2A)
                    )
                ) {
                    Text("+", fontSize = 24.sp)
                }
            }

            // Badge de estado
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(statusInfo.second)
                    .padding(horizontal = 24.dp, vertical = 10.dp)
            ) {
                Text(
                    text = statusInfo.first,
                    fontSize = 13.sp,
                    letterSpacing = 1.5.sp,
                    fontWeight = FontWeight.Medium,
                    color = statusInfo.third
                )
            }
        }
    }
}