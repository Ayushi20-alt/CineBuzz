package com.example.cinebuzz.profilefragParts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R
import com.example.cinebuzz.homerecycler1adapter
import com.example.cinebuzz.homerecyler1card_data


class wishlishtfrag : Fragment() {
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view : View =  inflater.inflate(R.layout.fragment_wishlishtfrag, container, false)

        recyclerView = view.findViewById(R.id.wishlistrecyler)
        recyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL,false)

        var arrList = ArrayList<wishlistcard_data>()
        arrList.add(wishlistcard_data(R.drawable.movie6, "Avengers"))
        arrList.add(wishlistcard_data(R.drawable.movie8, "Pulp Fiction"))
        arrList.add(wishlistcard_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrList.add(wishlistcard_data(R.drawable.movie10, "My Name is Khan"))
        arrList.add(wishlistcard_data(R.drawable.movie12, "K.G.F"))
        arrList.add(wishlistcard_data(R.drawable.movie13, "Raajneeti"))
        arrList.add(wishlistcard_data(R.drawable.movie6, "Avengers"))
        arrList.add(wishlistcard_data(R.drawable.movie8, "Pulp Fiction"))
        arrList.add(wishlistcard_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrList.add(wishlistcard_data(R.drawable.movie10, "My Name is Khan"))
        arrList.add(wishlistcard_data(R.drawable.movie12, "K.G.F"))
        arrList.add(wishlistcard_data(R.drawable.movie13, "Raajneeti"))

       val recycleradapter = this.activity?.let { wishlistadapter(it, arrList) }
        recyclerView.adapter = recycleradapter


        return view
    }

}