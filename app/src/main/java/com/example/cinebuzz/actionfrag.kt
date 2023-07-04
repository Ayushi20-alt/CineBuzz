package com.example.cinebuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

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