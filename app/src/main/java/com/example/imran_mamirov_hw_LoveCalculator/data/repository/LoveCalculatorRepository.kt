package com.example.imran_mamirov_hw_LoveCalculator.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveApiService
import com.example.imran_mamirov_hw_LoveCalculator.data.model.LoveResult
import javax.inject.Inject

class LoveCalculatorRepository @Inject constructor(
    private val api: LoveApiService
) {

    private var loveResults = MutableLiveData<LoveResult>()

    fun getLoveResult(firstName: String, secondName: String): MutableLiveData<LoveResult> {
        api.getPercentage(
            key = "7feead24fbmshdacc8cfdc5702cap159d4cjsn9b7673a34788",
            host = "love-calculator.p.rapidapi.com",
            firstName = firstName,
            secondName = secondName
        ).enqueue(object :
            retrofit2.Callback<LoveResult> {
            override fun onResponse(
                call: retrofit2.Call<LoveResult>,
                response: retrofit2.Response<LoveResult>
            ) {
                loveResults.value = response.body()
            }

            override fun onFailure(call: retrofit2.Call<LoveResult>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return loveResults
    }

}