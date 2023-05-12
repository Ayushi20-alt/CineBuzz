package com.example.cinebuzz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.FragmentFragmentotpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class fragmentotp : Fragment() {
    private var _binding: FragmentFragmentotpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentotpBinding.inflate(inflater, container, false)
        binding.materialButton1.setOnClickListener {

            val pass = binding.textInputEditText3.text.toString().trim()

            if (pass.isEmpty()) {
                binding.textInputEditText3.error = "otp required"
                binding.textInputEditText3.requestFocus()
                return@setOnClickListener
            }
            val retrofit = Retrofit.Builder()
                .baseUrl("https://cinebuzz-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val cineservice1 = retrofit.create(cineservice1::class.java)
            val otpmodelclass = otpmodelclass("ayushi@gmail.com", "56784s")
            val call = cineservice1.otpverify(otpmodelclass)

            call.enqueue(object : Callback<otpmodelclass> {
                override fun onResponse(
                    call: Call<otpmodelclass>,
                    response: Response<otpmodelclass>
                ) {
                   requireArguments().getString("emailId")
                    if (response.isSuccessful()) {
                        findNavController().navigate(R.id.action_fragmentotp_to_fragchangePass)
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

                override fun onFailure(call: Call<otpmodelclass>, t: Throwable) {
                    Log.d("implemented","not implemented")
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
