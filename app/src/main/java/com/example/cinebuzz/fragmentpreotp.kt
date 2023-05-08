package com.example.cinebuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.FragmentFragmentpreotpBinding

class fragmentpreotp : Fragment() {
    private var _binding : FragmentFragmentpreotpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentpreotpBinding.inflate(inflater,container,false)

        binding?.Button?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentpreotp_to_fragmentotp)
        }

        return binding?.root
    }

}