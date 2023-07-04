package com.example.cinebuzz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class trendingfrag : Fragment() {
    private lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_trendingfrag, container, false)

//        val toolbar : Toolbar = view.findViewById(R.id.ttolbar)
//        toolbar.visibility = View.GONE

//        val bottomNavigationView : BottomNavigationView = view.findViewById(R.id.navigationView)
//        bottomNavigationView.visibility = View.GONE
        recyclerView = view.findViewById(R.id.recyclerviewtrend)
        recyclerView.layoutManager = GridLayoutManager(this.activity, 2)
        var arrayList2 = ArrayList<homerecyler1card_data>()
        arrayList2.add(homerecyler1card_data(R.drawable.movie6, "Avengers"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie8, "Pulp Fiction"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie10, "My Name is Khan"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie12, "K.G.F"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie13, "Raajneeti"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie14, "Sinister"))

        val MyAdapter3 = activity?.let { trendrecyclerAdapter(it, arrayList2) }
        recyclerView.adapter = MyAdapter3
       return view
    }

}