package com.example.cinebuzz.Homefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R
import com.example.cinebuzz.dataclass.trendingmodelclassX
import com.example.cinebuzz.otherfiles.retrofitInstance
import com.example.cinebuzz.recycleradapter.trendrecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class actionfrag : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_actionfrag, container, false)


        recyclerView = view.findViewById(R.id.recyclerviewaction)
        recyclerView.layoutManager = GridLayoutManager(this.activity, 2)
        retrofitInstance.init().action().enqueue(object : Callback<ArrayList<trendingmodelclassX>?> {
            override fun onResponse(
                call: Call<ArrayList<trendingmodelclassX>?>,
                response: Response<ArrayList<trendingmodelclassX>?>
            ) {
                if(response.isSuccessful())
                {
                    val Myadapter = activity?.let { response.body()
                        ?.let { it1 -> trendrecyclerAdapter(it, it1) } }
                    recyclerView.adapter = Myadapter
                }
            }

            override fun onFailure(call: Call<ArrayList<trendingmodelclassX>?>, t: Throwable) {
                Toast.makeText(activity, "failed", Toast.LENGTH_LONG).show()
            }
        })

        return view
    }

}