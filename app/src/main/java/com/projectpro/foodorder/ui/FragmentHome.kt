package com.projectpro.foodorder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.projectpro.foodorder.R
import com.projectpro.foodorder.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 */
class FragmentHome : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val bind get() = _binding!!

    private lateinit var dummyCollectionAdapter: DummyCollectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return bind.rootHomeFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val vp2 = bind.screenRootVP2
        val tab = bind.tabLayout

        dummyCollectionAdapter = DummyCollectionAdapter(this)
        vp2.apply {
            adapter = dummyCollectionAdapter
            orientation = ViewPager2.ORIENTATION_VERTICAL
        }
        TabLayoutMediator(tab, vp2) {tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class DummyCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 5

        override fun createFragment(position: Int): Fragment {
            // Return a NEW fragment instance in createFragment(int)
            val fragment = DummyObjectFragment()
            fragment.arguments = Bundle().apply {
                // Our object is just an integer :-P
                putInt(ARG_OBJECT, position + 1)
            }
            return fragment
        }
    }


    // Instances of this class are fragments representing a single
    // object in our collection.
    class DummyObjectFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.dummy_screen, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
                val textView: TextView = view.findViewById(R.id.tvTitle)
                textView.text = getInt(ARG_OBJECT).toString()
            }
        }
    }

    companion object {
        private const val ARG_OBJECT = "object"
    }
}

