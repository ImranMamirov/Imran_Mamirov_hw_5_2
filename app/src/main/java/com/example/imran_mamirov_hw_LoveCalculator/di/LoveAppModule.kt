package com.example.imran_mamirov_hw_LoveCalculator.di

import android.content.Context
import android.content.SharedPreferences
import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoveAppModule {

    @Provides
    fun ProvideApi(): LoveApiService{
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApiService::class.java)
    }
}