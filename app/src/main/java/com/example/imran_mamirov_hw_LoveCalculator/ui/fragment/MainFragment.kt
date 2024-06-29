package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.FragmentMainFragmentBinding
import com.example.imran_mamirov_hw_LoveCalculator.SharedPreferences

@Suppress("UNREACHABLE_CODE")
class MainFragment : Fragment() {

    private val binding by lazy {
        FragmentMainFragmentBinding.inflate(layoutInflater)
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
            findNavController().navigate(R.id.action_mainFragmentFragment_to_loveCalculatorFragment)
        } else {
            binding.startBtn.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragmentFragment_to_onBoardFragment)
            }
        }
    }
}