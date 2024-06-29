package com.example.imran_mamirov_hw_LoveCalculator

import android.content.Context
import android.content.SharedPreferences

object SharedPreferences {

    private const val PREFERENCES_NAME = "love_calculator_prefs"
    private const val KEY_ON_BOARDING_COMPLETE = "on_boarding_complete"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun isOnboardingComplete(context: Context): Boolean {
        return getPreferences(context).getBoolean(KEY_ON_BOARDING_COMPLETE, false)
    }

    fun setOnboardingComplete(context: Context, complete: Boolean) {
        getPreferences(context).edit().putBoolean(KEY_ON_BOARDING_COMPLETE, complete).apply()
    }
}