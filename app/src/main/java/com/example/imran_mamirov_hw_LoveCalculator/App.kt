package com.example.imran_mamirov_hw_LoveCalculator

import android.app.Application
import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveApiService
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class App: Application()