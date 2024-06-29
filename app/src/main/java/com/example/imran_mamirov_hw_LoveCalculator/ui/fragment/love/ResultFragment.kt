package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.love

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private val binding: FragmentResultBinding by lazy {
        FragmentResultBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getInt("percentage")

        tvYouResult.text = firstName
        tvMeResult.text = secondName
        tvProcent.text = "$percentage%"

        btnTryAgain.setOnClickListener {
            val loveCalculatorFragment = LoveCalculatorFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loveCalculatorFragment).addToBackStack(null)
                .commit()
        }
    }
}