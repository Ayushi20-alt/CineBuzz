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
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

            val otp = binding.textInputEditText3.text.toString().trim()
            val name = requireArguments().getString("nameval").toString()
            Log.d("importantzzz",name)
            val email = requireArguments().getString("emailID").toString()
            Log.d("importantzzz", email)

            if (otp.isEmpty()) {
                binding.textInputEditText3.error = "otp required"
                binding.textInputEditText3.requestFocus()
                return@setOnClickListener
            }
            if (email != null) {
                if (email.isEmpty()) {
                    Toast.makeText(activity, "provide email", Toast.LENGTH_LONG)
                }
            }

            retrofitInstance.init().otpverify(otpmodelclass(email, otp))
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful()) {
                        findNavController().navigate(R.id.action_fragmentotp_to_fragchangePass, Bundle().apply {
                            putString("nameyaay", name)
                            putString("emailyaay",email)
                        })
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
                    Log.d("implemented","not implemented otp")
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
