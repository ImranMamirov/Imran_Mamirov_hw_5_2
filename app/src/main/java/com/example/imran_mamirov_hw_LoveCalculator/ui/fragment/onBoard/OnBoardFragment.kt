package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.FragmentOnBoardBinding
import com.example.imran_mamirov_hw_LoveCalculator.SharedPreferences

class OnBoardFragment : Fragment() {

    private val binding by lazy {
        FragmentOnBoardBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (SharedPreferences.isOnboardingComplete(requireContext())) {
            findNavController().navigate(R.id.action_onBoardFragment_to_loveCalculatorFragment)
        } else {
            setupViewPager()
        }
    }

    private fun setupViewPager() {
        val adapter = OnBoardAdapter(requireActivity())
        binding.viewPager2.adapter = adapter
    }
}