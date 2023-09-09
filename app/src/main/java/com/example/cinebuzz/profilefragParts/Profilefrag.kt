package com.example.cinebuzz.profilefragParts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.cinebuzz.R
import com.example.cinebuzz.otherfiles.retrofitInstance
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class profilefrag : Fragment() {

    var tabtitle = arrayOf("Wishlist","History");
    private lateinit var textview : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profilefrag, container, false)

        var pager = view.findViewById<ViewPager2>(R.id.viewPager2)
        var tl = view.findViewById<TabLayout>(R.id.tabLayout)
        pager.adapter = Myadapter(parentFragmentManager, lifecycle)
//        val email = requireArguments().getString("emailportfolio").toString()
//        Log.d("portfolio",email)

        textview = view.findViewById(R.id.textView14)
        Toast.makeText(activity, "api called for count", Toast.LENGTH_LONG).show()
        retrofitInstance.init().count().enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                if(response.isSuccessful())
                {
                    Toast.makeText(activity,"Success",Toast.LENGTH_LONG).show()
                    val num = response.body()
                    textview.text = num.toString()
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(activity,"failure",Toast.LENGTH_LONG).show()
            }
        })

        // to set the text of the tab layout
        TabLayoutMediator(tl,pager){
           tab, position ->
            tab.text = tabtitle[position]
        }.attach()

        return view
    }

}