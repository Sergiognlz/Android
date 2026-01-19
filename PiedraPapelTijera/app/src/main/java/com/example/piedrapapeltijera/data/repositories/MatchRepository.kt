package com.example.piedrapapeltijera.data.repositories



import com.example.piedrapapeltijera.data.dal.MatchDao
import com.example.piedrapapeltijera.model.MatchModel
import kotlinx.coroutines.flow.Flow

class MatchRepository(private val dao: MatchDao) {

    fun getAllMatches(): Flow<List<MatchModel>> = dao.getAllMatches()

    suspend fun insertMatch(match: MatchModel) = dao.insertMatch(match)

    suspend fun clearAll() = dao.clearAll()
}