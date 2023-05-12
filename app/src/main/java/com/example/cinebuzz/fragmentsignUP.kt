package com.example.cinebuzz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.databinding.FragmentFragmentsignUPBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class fragmentsignUP : Fragment() {
   private var _binding : FragmentFragmentsignUPBinding? = null
    private  val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentsignUPBinding.inflate(inflater,container,false)

        binding.materialButton1.setOnClickListener {

            val email = binding.textInputEditText1.text.toString().trim()
            val name = binding.textInputEditText2.text.toString().trim()

            if(email.isEmpty()){
                binding.textInputEditText1.error = "Email required"
                binding.textInputEditText1.requestFocus()
                return@setOnClickListener
            }

            if(name.isEmpty()){
                binding.textInputEditText2.error = "Name required"
                binding.textInputEditText2.requestFocus()
                return@setOnClickListener
            }

            val retrofit = Retrofit.Builder()
                .baseUrl("https://cinebuzz-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val cineservice1 = retrofit.create(cineservice1::class.java)
            val signUpmodelclass = signUpmodelclass("raju@gmail.com","iloveraju")
            val call = cineservice1.createnew(signUpmodelclass)

            call.enqueue(object : Callback<signUpmodelclass> {
                override fun onResponse(call: Call<signUpmodelclass>, response: Response<signUpmodelclass>) {
                    if (response.isSuccessful()) {
                        findNavController().navigate(R.id.action_fragmentsignUP_to_mainActivity)
                        Toast.makeText(activity, "Sucessfull", Toast.LENGTH_LONG)
                    }
                    else {
                        when (response.code().toString()) {
                             "422" -> Toast.makeText(activity, "Unprocessed Entity", Toast.LENGTH_LONG)
                            else -> Toast.makeText(activity, "null", Toast.LENGTH_LONG)
                        }
                        Log.d("implemented", response.raw().toString())
                    }
                }

                override fun onFailure(call: Call<signUpmodelclass>, t: Throwable) {
                    Log.d("implemented","not implemented")
                }

                 })

    }
        binding?.txtSignIn?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentsignUP_to_fragmentSignin)
        }

        return binding?.root
}
}