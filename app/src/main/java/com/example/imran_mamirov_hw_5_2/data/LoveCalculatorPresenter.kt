package com.example.imran_mamirov_hw_5_2.data

import com.example.imran_mamirov_hw_5_2.App
import com.example.imran_mamirov_hw_5_2.LoveResult
import com.example.imran_mamirov_hw_5_2.data.contract.LoveCalculatorContract
import retrofit2.Callback

class LoveCalculatorPresenter(private val view: LoveCalculatorContract.View) :
    LoveCalculatorContract.Presenter {

    override fun calculateLovePercentage(firstName: String, secondName: String) {
        App().api.getPercentage(
            key = "13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c",
            host = "love-calculator.p.rapidapi.com",
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveResult> {
            override fun onResponse(call: retrofit2.Call<LoveResult>, response: retrofit2.Response<LoveResult>) {
                if (response.isSuccessful && response.body() != null) {
                    view.showResult(response.body()!!)
                } else {
                    view.showError("Error: ${response.message()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<LoveResult>, t: Throwable) {
                view.showError("Failure: ${t.message}")
            }
        })
    }
}