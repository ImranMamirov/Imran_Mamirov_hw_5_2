package com.example.imran_mamirov_hw_5_2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.imran_mamirov_hw_5_2.LoveResult
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.data.contract.LoveCalculatorContract
import com.example.imran_mamirov_hw_5_2.data.LoveCalculatorPresenter
import com.example.imran_mamirov_hw_5_2.databinding.FragmentLoveCalculatorBinding

class LoveCalculatorFragment : Fragment(), LoveCalculatorContract.View {

    private val binding by lazy {
        FragmentLoveCalculatorBinding.inflate(layoutInflater)
    }
    private lateinit var presenter: LoveCalculatorPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoveCalculatorPresenter(this@LoveCalculatorFragment)

        btnCalculate.setOnClickListener {
            val firstName = etFname.text.toString()
            val secondName = etSname.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            presenter.calculateLovePercentage(firstName, secondName)
        }
    }

    override fun showResult(result: LoveResult) {
        val percentage = result.percentage.toIntOrNull() ?: 0
        val bundle = Bundle().apply {
            putString("firstName", result.fname)
            putString("secondName", result.sname)
            putInt("percentage", percentage)
        }
        val resultFragment = ResultFragment().apply {
            arguments = bundle
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, resultFragment)
            .addToBackStack(null).commit()
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}