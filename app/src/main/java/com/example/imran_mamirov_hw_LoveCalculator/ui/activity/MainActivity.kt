package com.example.imran_mamirov_hw_LoveCalculator.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.ActivityMainBinding
import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveApiService
import com.example.imran_mamirov_hw_LoveCalculator.history.HistoryDao
import com.example.imran_mamirov_hw_LoveCalculator.sharedpreference.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

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

        if (!sharedPreferences.isOnboardingComplete()) {
            sharedPreferences.setOnboardingComplete(true)
        } else {
            navController.navigate(R.id.loveCalculatorFragment)
        }
    }
}