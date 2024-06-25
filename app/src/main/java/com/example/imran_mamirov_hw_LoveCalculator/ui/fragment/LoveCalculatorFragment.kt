package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.FragmentLoveCalculatorBinding

class LoveCalculatorFragment : Fragment() {

    private val binding by lazy {
        FragmentLoveCalculatorBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[LoveCalculatorViewModel::class.java]
    }

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

    fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            val firstName = etFname.text.toString()
            val secondName = etSname.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            viewModel.getLoveResults(
                firstName = firstName,
                secondName = secondName
            ).observe(viewLifecycleOwner) { loveResults ->
                if (loveResults != null) {
                    val percentage = loveResults.percentage.toIntOrNull() ?: 0
                    val bundle = Bundle().apply {
                        putString("firstName", firstName)
                        putString("secondName", secondName)
                        putInt("percentage", percentage)
                    }
                    val resultFragment = ResultFragment().apply {
                        arguments = bundle
                    }
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, resultFragment)
                        .addToBackStack(null).commit()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error: ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}