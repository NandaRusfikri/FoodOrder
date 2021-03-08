package com.projectpro.foodorder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.projectpro.foodorder.R
import com.projectpro.foodorder.adapter.DummyCollectionAdapter
import com.projectpro.foodorder.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 */
class FragmentHome : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val bind get() = _binding!!

    private lateinit var dummyCollectionAdapter: DummyCollectionAdapter

    // tab titles
    private val titles = arrayOf(
        "Coffee",
        "Non Coffee",
        "Snack"
    )

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

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = resources.getString(R.string.app_name)

        dummyCollectionAdapter = DummyCollectionAdapter(this)
        vp2.apply {
            adapter = dummyCollectionAdapter
            orientation = ViewPager2.ORIENTATION_VERTICAL
        }
        TabLayoutMediator(tab, vp2) { tab, position ->
            tab.text = titles[position]
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

