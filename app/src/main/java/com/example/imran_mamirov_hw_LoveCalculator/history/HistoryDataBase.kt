package com.example.imran_mamirov_hw_LoveCalculator.history

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HistoryEntity::class], version = 1, exportSchema = false)
abstract class HistoryDataBase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object {
        @Volatile

        private var INSTANCE: HistoryDataBase? = null

        fun getDataBase(context: Context): HistoryDataBase {
            return INSTANCE ?: synchronized(this) {
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   HistoryDataBase::class.java,
                   "history_database"
               ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}