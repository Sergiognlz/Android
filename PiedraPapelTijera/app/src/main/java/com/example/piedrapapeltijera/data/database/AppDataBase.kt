package com.example.piedrapapeltijera.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.piedrapapeltijera.data.dal.MatchDao
import com.example.piedrapapeltijera.model.MatchModel



@Database(entities = [MatchModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
}