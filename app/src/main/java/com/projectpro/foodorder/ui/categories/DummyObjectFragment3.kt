package com.projectpro.foodorder.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.projectpro.foodorder.R
import com.projectpro.foodorder.utils.Constants.Companion.ARG_OBJECT

class DummyObjectFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dummy_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
//        }
        val textView: TextView = view.findViewById(R.id.tvTitle)
        textView.text = "getString(ARG_OBJECT).toString() 2"
    }
}