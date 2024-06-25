package com.example.imran_mamirov_hw_5_2.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.ui.fragment.LoveCalculatorFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoveCalculatorFragment())
                .commit()
        }
    }
}