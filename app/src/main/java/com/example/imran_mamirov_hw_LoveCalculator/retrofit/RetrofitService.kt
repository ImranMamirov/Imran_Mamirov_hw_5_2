package com.example.imran_mamirov_hw_LoveCalculator.retrofit

import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val api = retrofit.create(LoveApiService::class.java)
}