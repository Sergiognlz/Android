package com.example.piedrapapeltijera.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val playerName: String,
    val aiName: String,
    val format: String,      // "BO3" o "BO5"
    val playerScore: Int,
    val aiScore: Int,
    val winner: String,
    val timestamp: Long = System.currentTimeMillis()
)