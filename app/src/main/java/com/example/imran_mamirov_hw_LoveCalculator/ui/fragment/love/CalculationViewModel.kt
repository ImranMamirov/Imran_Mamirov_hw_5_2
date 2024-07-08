package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.love

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imran_mamirov_hw_LoveCalculator.data.local.HistoryDao
import com.example.imran_mamirov_hw_LoveCalculator.data.local.HistoryEntity
import com.example.imran_mamirov_hw_LoveCalculator.data.network.LoveApiService
import com.example.imran_mamirov_hw_LoveCalculator.data.network.LoveResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculationViewModel @Inject constructor(
    private val api: LoveApiService,
    private val dao: HistoryDao
) : ViewModel() {

    val loveResultData = MutableLiveData<LoveResult>()
    val errorData = MutableLiveData<String>()

    fun getPercentage(firstName: String, secondName: String) {
        api.getPercentage(
            firstName = firstName,
            secondName = secondName,
            key = "7feead24fbmshdacc8cfdc5702cap159d4cjsn9b7673a34788",
            host = "love-calculator.p.rapidapi.com"
        ).enqueue(object : retrofit2.Callback<LoveResult> {

            override fun onResponse(
                call: retrofit2.Call<LoveResult>,
                response: retrofit2.Response<LoveResult>
            ) {

                if (response.isSuccessful && response.body() != null) {
                    val loveResult = response.body()!!
                    saveToHistory(firstName, secondName, loveResult)
                    loveResultData.postValue(loveResult)
                } else {
                    errorData.postValue("Could not get a correct answer")
                }
            }

            override fun onFailure(call: retrofit2.Call<LoveResult>, t: Throwable) {
                errorData.postValue("Connection error")
            }
        })
    }

    private fun saveToHistory(firstName: String, secondName: String, loveResult: LoveResult) {
        val historyEntity = HistoryEntity(
            firstName = firstName,
            secondName = secondName,
            result = loveResult.result,
            lovePercentage = loveResult.percentage
        )
        dao.insertHistory(historyEntity)
    }
}