package com.example.imran_mamirov_hw_LoveCalculator.history

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HistoryDataBase {
        return Room.databaseBuilder(
            context,
            HistoryDataBase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideHistoryDao(database: HistoryDataBase): HistoryDao {
        return database.historyDao()
    }
}