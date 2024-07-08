package com.example.imran_mamirov_hw_LoveCalculator.Application

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferences @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val SHOWN = "shown"
    }

    fun isOnboardingComplete(): Boolean {
        return sharedPreferences.getBoolean(SHOWN, false)
    }

    fun setOnboardingComplete(b: Boolean) {
        sharedPreferences.edit().putBoolean(SHOWN, true).apply()
    }
}