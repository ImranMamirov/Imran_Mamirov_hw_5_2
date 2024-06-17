package com.example.imran_mamirov_hw_5_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imran_mamirov_hw_5_2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            App().api.getPercentage(
                key = "7feead24fbmshdacc8cfdc5702cap159d4cjsn9b7673a34788",
                host = "love-calculator.p.rapidapi.com",
                firstName = binding.etFirstName.text.toString(),
                secondName = binding.etSecondName.text.toString()
            ).enqueue(object : Callback<LoveResult> {
                override fun onResponse(call: Call<LoveResult>, response: Response<LoveResult>) {
                    if (response.code() in 200..299 && response.body() != null) {
                        val loveResult = response.body()
                        val intent = Intent(this@MainActivity, ResultActivity::class.java).apply {
                            putExtra("fName", loveResult?.fname)
                            putExtra("sName", loveResult?.sname)
                            putExtra("Percentage", loveResult?.percentage)
                            putExtra("loveResult", loveResult?.result)
                        }
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<LoveResult>, throwable: Throwable) {
                    Toast.makeText(this@MainActivity, throwable.message, Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
    }
}