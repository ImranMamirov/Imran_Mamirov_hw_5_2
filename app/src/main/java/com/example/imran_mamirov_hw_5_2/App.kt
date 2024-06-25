package com.example.imran_mamirov_hw_5_2

import android.app.Application
import com.example.imran_mamirov_hw_5_2.data.api.LoveApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {

    val api: LoveApiService = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(LoveApiService::class.java)
}