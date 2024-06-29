package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.imran_mamirov_hw_LoveCalculator.data.model.LoveResult
import com.example.imran_mamirov_hw_LoveCalculator.data.repository.LoveCalculatorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveCalculatorViewModel @Inject constructor(
    private val repository: LoveCalculatorRepository
): ViewModel() {

    fun getLoveResults(firstName: String, secondName: String): LiveData<LoveResult> {
        return repository.getLoveResult(firstName, secondName)
    }

}