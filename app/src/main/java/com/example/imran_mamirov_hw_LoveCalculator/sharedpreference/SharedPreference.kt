package com.example.imran_mamirov_hw_LoveCalculator.sharedpreference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferences @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val SHOWN = "shown"
    }

    fun isOnboardingComplete(): Boolean {
        return sharedPreferences.getBoolean(SHOWN, false)
    }

    fun setOnboardingComplete() {
        sharedPreferences.edit().putBoolean(SHOWN, true).apply()
    }
}