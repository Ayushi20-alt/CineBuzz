package com.example.cinebuzz

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel


class homefrag : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList : ArrayList<Int>
//    private lateinit var adapter: slideradapter

    private lateinit var imageSlider: ImageSlider
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view : View = inflater.inflate(R.layout.fragment_homefrag, container, false)

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageslider)
        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.movie1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.movie2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.movie3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.movie4, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.movie5, ScaleTypes.FIT))


        imageSlider.setImageList(imageList)

        // code for first recycler view
        recyclerView = view.findViewById(R.id.homerecycler1)
        recyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
        var arrayContact = ArrayList<homerecyler1card_data>()
        arrayContact.add(homerecyler1card_data(R.drawable.movie6, "Avengers"))
        arrayContact.add(homerecyler1card_data(R.drawable.movie8, "Pulp Fiction"))
        arrayContact.add(homerecyler1card_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrayContact.add(homerecyler1card_data(R.drawable.movie10, "My Name is Khan"))
        arrayContact.add(homerecyler1card_data(R.drawable.movie12, "K.G.F"))
        arrayContact.add(homerecyler1card_data(R.drawable.movie13, "Raajneeti"))
        arrayContact.add(homerecyler1card_data(R.drawable.movie14, "Sinister"))

        val MyAdapter = activity?.let { homerecycler1adapter(it, arrayContact) }
        recyclerView.adapter = MyAdapter

        val image_view1 = view.findViewById<ImageView>(R.id.clickme1trending)
        image_view1.setOnClickListener {
            val trendingfrag = trendingfrag()
            val transaction : FragmentTransaction =requireFragmentManager().beginTransaction()
            transaction.replace(R.id.frame_layout,trendingfrag)
            transaction.commit()
        }

        // code for second recycler view
        recyclerView = view.findViewById(R.id.homerecycler2)
        recyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
        var arrayList = ArrayList<homerecyler1card_data>()
        arrayList.add(homerecyler1card_data(R.drawable.movie6, "Avengers"))
        arrayList.add(homerecyler1card_data(R.drawable.movie8, "Pulp Fiction"))
        arrayList.add(homerecyler1card_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrayList.add(homerecyler1card_data(R.drawable.movie10, "My Name is Khan"))
        arrayList.add(homerecyler1card_data(R.drawable.movie12, "K.G.F"))
        arrayList.add(homerecyler1card_data(R.drawable.movie13, "Raajneeti"))
        arrayList.add(homerecyler1card_data(R.drawable.movie14, "Sinister"))

        val MyAdapter2 = activity?.let { homerecycler1adapter(it, arrayList) }
        recyclerView.adapter = MyAdapter2

        val image_view2 = view.findViewById<ImageView>(R.id.clickme1action)
        image_view1.setOnClickListener {
            val actionfrag = actionfrag()
            val transaction : FragmentTransaction =requireFragmentManager().beginTransaction()
            transaction.replace(R.id.frame_layout,actionfrag)
            transaction.commit()
        }


        // code for the third recyler view
        recyclerView = view.findViewById(R.id.homerecycler3)
        recyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
        var arrayList2 = ArrayList<homerecyler1card_data>()
        arrayList2.add(homerecyler1card_data(R.drawable.movie6, "Avengers"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie8, "Pulp Fiction"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie10, "My Name is Khan"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie12, "K.G.F"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie13, "Raajneeti"))
        arrayList2.add(homerecyler1card_data(R.drawable.movie14, "Sinister"))

        val MyAdapter3 = activity?.let { homerecycler1adapter(it, arrayList2) }
        recyclerView.adapter = MyAdapter3


        // code for the fourth recycler view
        recyclerView = view.findViewById(R.id.homerecycler4)
        recyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
        var arrayList3 = ArrayList<homerecyler1card_data>()
        arrayList3.add(homerecyler1card_data(R.drawable.movie6, "Avengers"))
        arrayList3.add(homerecyler1card_data(R.drawable.movie8, "Pulp Fiction"))
        arrayList3.add(homerecyler1card_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrayList3.add(homerecyler1card_data(R.drawable.movie10, "My Name is Khan"))
        arrayList3.add(homerecyler1card_data(R.drawable.movie12, "K.G.F"))
        arrayList3.add(homerecyler1card_data(R.drawable.movie13, "Raajneeti"))
        arrayList3.add(homerecyler1card_data(R.drawable.movie14, "Sinister"))

        val MyAdapter4 = activity?.let { homerecycler1adapter(it, arrayList3) }
        recyclerView.adapter = MyAdapter4


        // code for the fifth recyler view
        recyclerView = view.findViewById(R.id.homerecycler5)
        recyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
        var arrayList4 = ArrayList<homerecyler1card_data>()
        arrayList4.add(homerecyler1card_data(R.drawable.movie6, "Avengers"))
        arrayList4.add(homerecyler1card_data(R.drawable.movie8, "Pulp Fiction"))
        arrayList4.add(homerecyler1card_data(R.drawable.movie7, "Bad Times of Lyla"))
        arrayList4.add(homerecyler1card_data(R.drawable.movie10, "My Name is Khan"))
        arrayList4.add(homerecyler1card_data(R.drawable.movie12, "K.G.F"))
        arrayList4.add(homerecyler1card_data(R.drawable.movie13, "Raajneeti"))
        arrayList4.add(homerecyler1card_data(R.drawable.movie14, "Sinister"))

        val MyAdapter5 = activity?.let { homerecycler1adapter(it, arrayList4) }
        recyclerView.adapter = MyAdapter5
//        init()
//        setUpTransformer()
//        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                // will automatically change the images
//                handler.removeCallbacks(runnable)
//                handler.postDelayed(runnable, 2000)
//            }
//        })

 return view
    }

//    override fun onPause() {
//        super.onPause()
//        handler.removeCallbacks(runnable)
//    }
//
//    override fun onResume() {
//        super.onResume()
//        handler.postDelayed(runnable, 2000)
//    }
//
//    private val  runnable = Runnable{
//        viewPager2.currentItem = viewPager2.currentItem + 1
//    }
//
//    public fun setUpTransformer(){
//        val transformer = CompositePageTransformer()
//        transformer.addTransformer(MarginPageTransformer(40))
//        transformer.addTransformer{ page, position->
//            val r = 1- abs(position)
//            page.scaleY = 0.85f + r * 0.14f
//        }
//        viewPager2.setPageTransformer(transformer)
//    }
//
//    private fun init(){
//        val viewPager2 = view?.findViewById<ViewPager2>(R.id.viewpager2)
//        handler = Handler(Looper.myLooper()!!)
//        imageList = ArrayList()
//
//        imageList.add(R.drawable.movie1)
//        imageList.add(R.drawable.movie2)
//        imageList.add(R.drawable.movie3)
//        imageList.add(R.drawable.movie4)
//        imageList.add(R.drawable.movie5)
//
////
//        val adapter = viewPager2?.let { slideradapter(imageList, it) }
//        if (viewPager2 != null) {
//            viewPager2.adapter = adapter
//            viewPager2.offscreenPageLimit =3
//            viewPager2.clipToPadding = false
//            viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
//        }
//    }
}