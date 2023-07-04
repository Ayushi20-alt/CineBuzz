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
import okhttp3.ResponseBody
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

        binding.textView2.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSignin_to_fragmentpreotp)
        }

        binding.temp.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSignin_to_activity)
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

           retrofitInstance.init().sendData(loginmodelclass(email,password))
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful()) {
                        findNavController().navigate(R.id.action_fragmentSignin_to_activity)
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

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("implemented","not implemented login")
                }
        })
    }
    fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
        return binding.root
}
}


