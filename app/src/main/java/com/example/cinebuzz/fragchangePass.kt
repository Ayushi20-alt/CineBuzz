package com.example.cinebuzz

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.FragmentFragchangePassBinding


class fragchangePass : Fragment() {
    private var _binding : FragmentFragchangePassBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding =  FragmentFragchangePassBinding.inflate(inflater, container, false)
        binding?.materialButton?.setOnClickListener {
            findNavController().navigate(R.id.action_fragchangePass_to_fragmentSignin)
        }
        return binding?.root

    }

    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {

       val inflater= super.onGetLayoutInflater(savedInstanceState)
        val contextThemeWrapper:Context =ContextThemeWrapper(requireContext(), R.style.Theme_CineBuzz_BackgroundImageStyle)
        return inflater.cloneInContext(contextThemeWrapper)
    }


}