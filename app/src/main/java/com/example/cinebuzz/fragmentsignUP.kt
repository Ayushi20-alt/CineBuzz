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
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            retrofitInstance.init().createnew(signUpmodelclass(email, name))
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful()) {
                        findNavController().navigate(R.id.action_fragmentsignUP_to_fragmentotp, Bundle().apply {
                            putString("emailID", email)
                            putString("nameval", name)
                        })
                        Toast.makeText(activity, "Sucessfull", Toast.LENGTH_LONG).show()
                    }
                    else {
                        when (response.code().toString()) {
                             "422" -> Toast.makeText(activity, "Unprocessed Entity", Toast.LENGTH_LONG).show()
                            else -> Toast.makeText(activity, "null", Toast.LENGTH_LONG).show()
                        }
                        Log.d("implemented", response.raw().toString())
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("implemented","not implemented signup")
                }

                 })

    }
        binding?.txtSignIn?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentsignUP_to_fragmentSignin)
        }

        return binding?.root
}
}