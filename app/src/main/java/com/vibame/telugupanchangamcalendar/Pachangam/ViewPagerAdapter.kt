package com.vibame.telugupanchangamcalendar.Pachangam

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        // Total number of fragments
        return 1000
    }




    override fun createFragment(position: Int): Fragment {
        // Create and return the fragment instance
        // Adjust position to ensure it starts from 500
        val adjustedPosition = position + 500
        return DailyFragment.newInstance(adjustedPosition)
    }


}
