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
import com.example.cinebuzz.databinding.FragmentChangePassfragBinding
import com.example.cinebuzz.dataclass.resetpasss
import com.example.cinebuzz.otherfiles.retrofitInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChangePassfrag : Fragment() {
      private var _binding : FragmentChangePassfragBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentChangePassfragBinding.inflate(inflater, container, false)

        val email = requireArguments().getString("emailchangepass").toString()
        Log.d("importantzzz",email)

        binding.materialButton.setOnClickListener {
            val email = requireArguments().getString("emailchangepass").toString()
            Log.d("importantzzz",email)

            val pass = binding.inputtextpassword.text.toString()
            if (pass.isEmpty()) {
                binding.inputtextpassword.error = "password required"
                binding.inputtextpassword.requestFocus()
                return@setOnClickListener
            }

            val confirmpass = binding.inputtextpassword2.text.toString()
            if(confirmpass.isEmpty()){
                binding.inputtextpassword2.error = "confirm password required"
                binding.inputtextpassword2.requestFocus()
                return@setOnClickListener
            }

            retrofitInstance.init().resetPass(resetpasss(confirmpass,email,pass))
                .enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ){
                        if (response.isSuccessful()) {
                            if(pass == confirmpass){
                                findNavController().navigate(R.id.action_changePassfrag_to_activity, Bundle().apply {
                                    putString("emailportfolio",email)
                                })
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

        return binding.root
     }


}