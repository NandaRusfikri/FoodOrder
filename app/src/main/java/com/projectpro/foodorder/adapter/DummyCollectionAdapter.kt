package com.projectpro.foodorder.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.projectpro.foodorder.ui.categories.DummyObjectFragment
import com.projectpro.foodorder.ui.categories.DummyObjectFragment2
import com.projectpro.foodorder.ui.categories.DummyObjectFragment3
import com.projectpro.foodorder.utils.Constants

class DummyCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3


    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
//        val fragment = DummyObjectFragment()
//        val fragment2 = DummyObjectFragment2()
//        val fragment3 = DummyObjectFragment3()
        when(position) {
            0 -> return DummyObjectFragment()
            1 -> return DummyObjectFragment2()
            2 -> return DummyObjectFragment3()
        }
        return DummyObjectFragment()
    }
}

