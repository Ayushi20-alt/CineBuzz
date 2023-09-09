package com.example.cinebuzz.playerFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R


class playerfrag : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_playerfrag, container, false)

        recyclerView = view.findViewById(R.id.playerrecycler)
        recyclerView.layoutManager = GridLayoutManager(this.activity, 2)

        var arrayList5 = ArrayList<PlayerData_class>()
        arrayList5.add(PlayerData_class(R.drawable.movie6, "Action"))
        arrayList5.add(PlayerData_class(R.drawable.movie8, "Romance"))
        arrayList5.add(PlayerData_class(R.drawable.movie7, "Suspense"))
        arrayList5.add(PlayerData_class(R.drawable.movie10, "Drama"))
        arrayList5.add(PlayerData_class(R.drawable.movie12, "Bollywood"))
        arrayList5.add(PlayerData_class(R.drawable.movie14, "Horror"))
        arrayList5.add(PlayerData_class(R.drawable.movie13, "Others"))

        val MyAdapter6 = activity?.let { playerrecycler_adapter(it, arrayList5) }
        recyclerView.adapter = MyAdapter6
        return view
    }

}