package com.example.cinebuzz.Authfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.R
import com.example.cinebuzz.databinding.FragmentFragmentpreotpBinding
import com.example.cinebuzz.dataclass.changepassEmail
import com.example.cinebuzz.otherfiles.retrofitInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class fragmentpreotp : Fragment() {
    private var _binding : FragmentFragmentpreotpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentpreotpBinding.inflate(inflater,container,false)

        binding.Button.setOnClickListener {
            val email = binding.textInputEditText3.text.toString().trim()

            if (email.isEmpty()) {
                binding.textInputEditText3.error = "email required"
                binding.textInputEditText3.requestFocus()
                return@setOnClickListener
            }

            retrofitInstance.init().forgotpass(changepassEmail(email))
                .enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        if (response.isSuccessful()) {
                            findNavController().navigate(R.id.action_fragmentpreotp_to_changePassfrag, Bundle().apply {
                                putString("emailchangepass",email)
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
                        Log.d("implemented","not implemented emailchangepass")
                    }
                })

        }

       return binding.root
    }

}