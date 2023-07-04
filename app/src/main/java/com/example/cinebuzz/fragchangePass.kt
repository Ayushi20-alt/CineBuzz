package com.example.cinebuzz

import android.content.Context
import android.os.Bundle
import retrofit2.Callback
import android.util.Log
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.FragmentFragchangePassBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response


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
            val name = requireArguments().getString("nameyaay").toString()
            Log.d("importantzzz", name)
            val email = requireArguments().getString("emailyaay").toString()
            Log.d("importantzzz", email)

            val pass = binding!!.inputtextpassword.text.toString()
            if (pass.isEmpty()) {
                binding!!.inputtextpassword.error = "password required"
                binding!!.inputtextpassword.requestFocus()
                return@setOnClickListener
            }

            val confirmpass = binding!!.inputtextpassword2.text.toString()
            if(confirmpass.isEmpty()){
                binding!!.inputtextpassword2.error = "password required again"
                binding!!.inputtextpassword2.requestFocus()
                return@setOnClickListener
            }

            retrofitInstance.init().createpass(createpassmodelclass(name,email,pass,confirmpass))
                .enqueue(object : Callback<ResponseBody>{
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ){
                        if (response.isSuccessful()) {
                             if(pass == confirmpass){
                                 findNavController().navigate(R.id.action_fragchangePass_to_activity)
                             }
                                Toast.makeText(activity, null, Toast.LENGTH_LONG)

                        } else {
                            when (response.code().toString()) {

                                "422" -> Toast.makeText(
                                    activity,
                                    "Unprocessed Entity",
                                    Toast.LENGTH_LONG
                                ).show()

                                else -> Toast.makeText(activity, null, Toast.LENGTH_LONG).show()
                            }
                            Log.d("implemented", response.raw().toString())
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Log.d("implemented","not implemented create pass")
                    }
                })

        }
        return binding?.root

    }

//    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
//
//       val inflater= super.onGetLayoutInflater(savedInstanceState)
//        val contextThemeWrapper:Context =ContextThemeWrapper(requireContext(), R.style.Theme_CineBuzz_BackgroundImageStyle)
//        return inflater.cloneInContext(contextThemeWrapper)
//    }


}