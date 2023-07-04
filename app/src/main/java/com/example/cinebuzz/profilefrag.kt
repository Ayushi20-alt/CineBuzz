package com.example.cinebuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cinebuzz.profilefragParts.Myadapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class profilefrag : Fragment() {

    var tabtitle = arrayOf("Wishlist","History");

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profilefrag, container, false)

        var pager = view.findViewById<ViewPager2>(R.id.viewPager2)
        var tl = view.findViewById<TabLayout>(R.id.tabLayout)
        pager.adapter = Myadapter(parentFragmentManager, lifecycle)

        // to set the text of the tab layout
        TabLayoutMediator(tl,pager){
           tab, position ->
            tab.text = tabtitle[position]
        }.attach()

        return view
    }

}