package com.example.cinebuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.ActivityMainBinding
import com.example.cinebuzz.databinding.FragmentFragmentsignUPBinding

class fragmentsignUP : Fragment() {
   private var _binding : FragmentFragmentsignUPBinding? = null
    private  val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentsignUPBinding.inflate(inflater,container,false)

        binding?.materialButton1?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSignin_to_mainActivity)


        }

        binding?.txtSignIn?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentsignUP_to_fragmentSignin)
        }


        return binding?.root
    }


}