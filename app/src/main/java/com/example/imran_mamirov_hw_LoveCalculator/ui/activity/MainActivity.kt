package com.example.imran_mamirov_hw_LoveCalculator.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.ActivityMainBinding
import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveApiService
import com.example.imran_mamirov_hw_LoveCalculator.history.HistoryDao
import com.example.imran_mamirov_hw_LoveCalculator.sharedpreference.SharedPreferences
import com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.love.LoveCalculatorFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var loveApiService: LoveApiService

    @Inject
    lateinit var historyDao: HistoryDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        if (sharedPreferences.isOnboardingComplete()) {
            navController.navigate(R.id.action_onBoardFragment_to_loveCalculatorFragment)
        } else {
            navController.navigate(R.id.action_loveCalculatorFragment_to_resultFragment)
        }
    }
}