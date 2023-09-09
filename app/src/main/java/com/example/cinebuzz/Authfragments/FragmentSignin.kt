package com.example.cinebuzz.Authfragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.cinebuzz.DataStore
import com.example.cinebuzz.R
import com.example.cinebuzz.databinding.FragmentSigninBinding
import com.example.cinebuzz.dataclass.loginResponseX
import com.example.cinebuzz.dataclass.loginmodelclass
import com.example.cinebuzz.otherfiles.retrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
            .enqueue(object : Callback<loginResponseX> {
                override fun onResponse(call: Call<loginResponseX>, response: Response<loginResponseX>) {
                    if (response.isSuccessful()) {
                        lifecycleScope.launch {
                            DataStore(requireContext()).changeLoginState(true)
                            DataStore(requireContext()).saveAcessToken(response.body()?.token)
                            DataStore(requireContext()).saveUserId(response.body()!!.id)
                        }
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

                override fun onFailure(call: Call<loginResponseX>, t: Throwable) {
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


