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

        binding.materialButton.setOnClickListener{

            val email = binding.textInputEditText1.text.toString().trim()
            val password = binding.inputtextpassword.text.toString().trim()

            if(email.isEmpty()){
                binding.textInputEditText1.error = "Email required"
                binding.textInputEditText1.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                binding.inputPassword.error = "Password required"
                binding.inputtextpassword.requestFocus()
                return@setOnClickListener
            }

            val retrofit = Retrofit.Builder()
                .baseUrl("https://cinebuzz-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val cineservice1 = retrofit.create(cineservice1::class.java)
            val loginmodelclass = loginmodelclass("raju@gmail.com","iloveraju")
            val call = cineservice1.sendData(loginmodelclass)
                // networking method
            // callback is the interface which is implemented
            call.enqueue(object : Callback<loginmodelclass> {
                override fun onResponse(call: Call<loginmodelclass>, response: Response<loginmodelclass>) {
                    val data: loginmodelclass? = response.body()
                    if (response.isSuccessful()) {
                        findNavController().navigate(R.id.action_fragmentSignin_to_mainActivity)
                        Toast.makeText(activity, null, Toast.LENGTH_LONG)
                    }
                    else {
                        when (response.code().toString()) {

                            "401" -> Toast.makeText(activity, "User Unauthorized", Toast.LENGTH_LONG).show()
                            else -> Toast.makeText(activity, null, Toast.LENGTH_LONG).show()
                        }
                        Log.d("implemented", response.raw().toString())
                    }
                }

                override fun onFailure(call: Call<loginmodelclass>, t: Throwable) {
                    Log.d("implemented","not implemented")
                }
        })

        // send data

        // performance benift hota h to free the memory and destroy the view
    }
    fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
        return binding.root
}
}


