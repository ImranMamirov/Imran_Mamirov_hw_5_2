package com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.onBoard

import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imran_mamirov_hw_LoveCalculator.ui.fragment.onBoard.OnBoardPagingFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardAdapter(fragment: OnboardFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): OnBoardPagingFragment {
        val fragment = OnBoardPagingFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
        return fragment
    }
}