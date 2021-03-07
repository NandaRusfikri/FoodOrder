package com.projectpro.foodorder.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.projectpro.foodorder.R
import com.projectpro.foodorder.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 */
class FragmentHome : Fragment() {

//    private var _binding: HomeFragmentBinding? = null
    private var _binding: FragmentHomeBinding? = null

    private val bind get() = _binding!!

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

        bind.btnExNavigation.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_detailItemFragment
            )
        }

    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//    }

}