package com.example.imran_mamirov_hw_LoveCalculator.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")

data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String,
    val secondName: String,
    val lovePercentage: String,
    val result: String,
)