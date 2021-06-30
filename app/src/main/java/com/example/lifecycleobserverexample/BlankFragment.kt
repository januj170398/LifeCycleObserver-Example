package com.example.lifecycleobserverexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycleobserverexample.databinding.ActivityMainBinding
import com.example.lifecycleobserverexample.databinding.FragmentBlankBinding


class BlankFragment : Fragment(R.layout.fragment_blank) {

    private var _binding : FragmentBlankBinding? = null
    private lateinit var myObserver : MyObserver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBlankBinding.bind(view)
        myObserver = MyObserver(context,lifecycle)
        lifecycle.addObserver(myObserver)
    }




}