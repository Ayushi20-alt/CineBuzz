package com.example.cinebuzz

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.FragmentSigninBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class fragmentSignin : Fragment() {

   private var _binding : FragmentSigninBinding? = null
    // point binding ko hi krega bus hum null safe krane ke liye use krege
    private val binding get() = _binding!!
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSigninBinding.inflate(inflater, container, false)

        binding.txtSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentSignin_to_fragmentsignUP)
        }

        binding.textView2.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentSignin_to_fragmentpreotp)
        }

        // Retrofit Builder
        var retrofit = Retrofit.Builder()
            .baseUrl("https://cinebuzz-production.up.railway.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        binding.materialButton.setOnClickListener{
            // create interface method
            val cineservice1 = retrofit.create(cineservice1::class.java)
            val cine1 = cine1("raju@gmail.com","iloveraju")
            val call = cineservice1.sendData(cine1)

            // networking method
            // callback is the interface which is implemented
            call.enqueue(object : Callback<cine1> {
                override fun onResponse(call: Call<cine1>, response: Response<cine1>) {
                    val data : cine1? = response.body()
                    if(data != null)
                    {

                    }
                    Log.d("implemented", response.raw().toString())
                }

                override fun onFailure(call: Call<cine1>, t: Throwable) {
                    Log.d("implemented","not implemneted")
                }
            })
            findNavController().navigate(R.id.action_fragmentSignin_to_mainActivity)
        }

        // send data

        // performance benift hota h to free the memory and destroy the view

        return binding.root

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

