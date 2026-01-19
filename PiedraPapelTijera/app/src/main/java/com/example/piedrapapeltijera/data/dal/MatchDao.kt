package com.example.piedrapapeltijera.data.dal

import androidx.room.*
import com.example.piedrapapeltijera.model.MatchModel

import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {

    @Query("SELECT * FROM matches ORDER BY timestamp DESC")
    fun getAllMatches(): Flow<List<MatchModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: MatchModel)

    @Query("DELETE FROM matches")
    suspend fun clearAll()
}