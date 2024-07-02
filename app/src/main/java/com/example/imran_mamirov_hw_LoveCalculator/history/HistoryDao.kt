package com.example.imran_mamirov_hw_LoveCalculator.history

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Insert
    suspend fun insertHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM history_table ORDER BY firstName ASC")
    suspend fun getAllHistorySorted(): List<HistoryEntity>

    @Delete
    suspend fun deleteHistory(historyEntity: HistoryEntity)
}