package com.projectpro.foodorder.ui.categories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectpro.foodorder.R
import com.projectpro.foodorder.adapter.AdapterMenu
import com.projectpro.foodorder.data.remote.model.Menus
import com.projectpro.foodorder.data.remote.model.MenusItem
import com.projectpro.foodorder.databinding.FragmentDummyObjectBinding
import com.projectpro.foodorder.utils.ViewModelFactory
import com.projectpro.foodorder.viewmodel.HomeViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentDummyObject : Fragment(R.layout.fragment_dummy_object) {

    private var _binding: FragmentDummyObjectBinding? = null
    private val bind get() = _binding!!

    private var menu: List<MenusItem> = ArrayList()

    private val homeViewModel by lazy {
        val viewModelFactory = activity?.application?.let { ViewModelFactory.getInstance() }
        viewModelFactory?.let { ViewModelProvider(this, it).get(HomeViewModel::class.java) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDummyObjectBinding.inflate(inflater, container, false)
        return bind.root1
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapterMenu = AdapterMenu()

        homeViewModel?.menusList?.observe(viewLifecycleOwner, {
            if (it.isNullOrEmpty()) {
                bind.tvTitle.text = "null or empty"
            } else {
                menu = it
                adapterMenu.addList(menu)
                bind.tvTitle.text = "List menu"
            }
        })


        bind.rvMenu1.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMenu
            setHasFixedSize(true)
        }

    }
}