package com.example.imran_mamirov_hw_5_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imran_mamirov_hw_5_2.databinding.ActivityResultBinding
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fName = intent.getStringExtra("fName")
        val sName = intent.getStringExtra("sName")

        val randomPercentage = Random.nextInt(0, 101)

        val matchResult = if (randomPercentage >= 50) {
            "Good Match"
        } else {
            "Not a Good Match"
        }

        binding.tvFName.text = fName?: "No data"
        binding.tvSName.text = sName?: "No data"
        binding.tvPercentage.text = "$randomPercentage%"
        binding.tvResult.text = matchResult
    }
}