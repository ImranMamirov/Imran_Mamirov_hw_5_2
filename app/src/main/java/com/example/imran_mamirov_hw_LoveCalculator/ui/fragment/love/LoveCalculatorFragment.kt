package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.love

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.FragmentLoveCalculatorBinding
import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveApiService
import com.example.imran_mamirov_hw_LoveCalculator.data.api.LoveResult
import com.example.imran_mamirov_hw_LoveCalculator.history.HistoryDao
import com.example.imran_mamirov_hw_LoveCalculator.history.HistoryEntity
import kotlinx.coroutines.launch
import okhttp3.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback


class LoveCalculatorFragment : Fragment() {

    private val binding by lazy {
        FragmentLoveCalculatorBinding.inflate(layoutInflater)
    }

    @Inject lateinit var api: LoveApiService
    @Inject lateinit var historyDao: HistoryDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            val firstName = etFname.text.toString()
            val secondName = etSname.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            api.getPercentage(
                firstName = firstName,
                secondName = secondName,
                key = "7feead24fbmshdacc8cfdc5702cap159d4cjsn9b7673a34788",
                host = "love-calculator.p.rapidapi.com"
            ).enqueue(object : retrofit2.Callback<LoveResult> {

                override fun onResponse(call: retrofit2.Call<LoveResult>, response: retrofit2.Response<LoveResult>) {
                    if (response.isSuccessful && response.body() != null) {
                        val loveResult = response.body()!!
                        saveToHistory(firstName, secondName, loveResult)
                        navigateToResultFragment(loveResult)
                    } else {
                        Toast.makeText(context, "Could not get a correct answer", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: retrofit2.Call<LoveResult>, t: Throwable) {
                    Toast.makeText(context, "Connection error", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun saveToHistory(firstName: String, secondName: String, loveResult: LoveResult) {
        lifecycleScope.launch {
            val historyEntity = HistoryEntity(
                firstName = firstName,
                secondName = secondName,
                result = loveResult.result,
                lovePercentage = loveResult.percentage
            )
            historyDao.insertHistory(historyEntity)
        }
    }

    private fun navigateToResultFragment(loveResult: LoveResult) {
        val bundle = Bundle().apply {
            putString("percentage", loveResult.percentage)
            putString("result", loveResult.result)
        }
        findNavController().navigate(R.id.action_loveCalculatorFragment_to_resultFragment, bundle)
    }
}