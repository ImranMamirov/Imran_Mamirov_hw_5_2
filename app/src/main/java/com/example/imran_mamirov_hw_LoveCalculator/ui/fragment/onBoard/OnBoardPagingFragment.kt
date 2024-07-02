package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imran_mamirov_hw_5_2.R
import com.example.imran_mamirov_hw_5_2.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private val binding by lazy {
        FragmentOnBoardPagingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        val position = arguments?.getInt(ARG_ONBOARD_POSITION) ?: 0
        with(binding) {
            when (position) {
                0 -> {
                    tvTitle.text = "It`s Funs and many more"
                }
                1 -> {
                    tvTitle.text = "Have a good time " +
                            "You Should take the time to help those who need you"
                }
                2 -> {
                    tvTitle.text = "Cherishing love " +
                            "It is now no longer possible for you to cherish love"
                }
                3 -> {
                    tvTitle.text = "Have a breakup? " +
                            "We have made the correction  for you don`t worry Maybe someone is waiting for you"
                }
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}