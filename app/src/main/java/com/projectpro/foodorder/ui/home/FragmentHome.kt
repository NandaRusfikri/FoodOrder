package com.projectpro.foodorder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.projectpro.foodorder.R
import com.projectpro.foodorder.adapter.DummyCollectionAdapter
import com.projectpro.foodorder.databinding.FragmentHomeBinding
import com.projectpro.foodorder.utils.ViewModelFactory
import com.projectpro.foodorder.viewmodel.HomeViewModel


/**
 * A simple [Fragment] subclass.
 */
class FragmentHome : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val bind get() = _binding!!

    private lateinit var dummyCollectionAdapter: DummyCollectionAdapter

    private val homeViewModel by lazy {
        val viewModelFactory = activity?.application?.let { ViewModelFactory.getInstance() }
        viewModelFactory?.let { ViewModelProvider(this, it).get(HomeViewModel::class.java) }
    }

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

        if (savedInstanceState == null) {
            checkConnectionDb()
        }

        val vp2 = bind.screenRootVP2
        val tab = bind.tabLayout

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = resources.getString(R.string.app_name)

        dummyCollectionAdapter = DummyCollectionAdapter(this)
        vp2.apply {
            adapter = dummyCollectionAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        TabLayoutMediator(tab, vp2) { tab, position ->
            tab.text = titles[position]
        }.attach()

    }

    private fun checkConnectionDb() {
        bind.pbLoadCheckConn.visibility = View.VISIBLE
        bind.screenRootVP2.visibility = View.INVISIBLE
        bind.tabLayout.visibility = View.INVISIBLE
        homeViewModel?.checkHealthCheck?.observe(viewLifecycleOwner, {
            bind.pbLoadCheckConn.visibility = View.GONE
            bind.screenRootVP2.visibility = View.VISIBLE
            bind.tabLayout.visibility = View.VISIBLE
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

