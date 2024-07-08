package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.love

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.FragmentLoveCalculatorBinding
import com.example.imran_mamirov_hw_LoveCalculator.data.network.LoveApiService
import com.example.imran_mamirov_hw_LoveCalculator.data.network.LoveResult
import com.example.imran_mamirov_hw_LoveCalculator.data.local.HistoryDao
import com.example.imran_mamirov_hw_LoveCalculator.data.local.HistoryEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {

    private var _binding: FragmentLoveCalculatorBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CalculationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.loveResultData.observe(viewLifecycleOwner) { result ->
            navigateToResultFragment(result)
        }
        viewModel.errorData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            val firstName = etFname.text.toString()
            val secondName = etSname.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            viewModel.getPercentage(firstName, secondName)
        }
    }

    private fun navigateToResultFragment(loveResult: LoveResult) {
        val bundle = Bundle().apply {
            putString("percentage", loveResult.percentage)
            putString("result", loveResult.result)
        }
        findNavController().navigate(R.id.action_loveCalculatorFragment_to_resultFragment, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}