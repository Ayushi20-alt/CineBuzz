package com.example.cinebuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.FragmentFragmentotpBinding


class fragmentotp : Fragment() {
     private var _binding : FragmentFragmentotpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentotpBinding.inflate(inflater,container,false)
        binding.materialButton1.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentotp_to_fragchangePass)
        }

       return binding.root
    }

}