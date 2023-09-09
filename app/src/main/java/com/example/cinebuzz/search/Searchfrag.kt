package com.example.cinebuzz.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import retrofit2.Callback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinebuzz.databinding.FragmentSearchfragBinding
import com.example.cinebuzz.dataclass.searchMoviemodelclass
import com.example.cinebuzz.otherfiles.retrofitInstance
import com.example.cinebuzz.recycleradapter.searchAdapter
import retrofit2.Call
import retrofit2.Response

class searchfrag : Fragment() {
    private var arrlist = ArrayList<searchMoviemodelclass>()
    private lateinit var adapter: searchAdapter
    private var _binding: FragmentSearchfragBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchfragBinding.inflate(inflater, container, false)


        binding?.searchrecyler?.setHasFixedSize(true)
        binding?.searchrecyler?.layoutManager =
            LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
//        addDataToTheList()



        binding?.searchView1?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
//                if (newText != null) {
//                    filterList(newText)
                retrofitInstance.init().searchMovie(searchMoviemodelclass(newText))
                    .enqueue(object: Callback<ArrayList<searchMoviemodelclass>>{

                        override fun onResponse(
                            call: Call<ArrayList<searchMoviemodelclass>>,
                            response: Response<ArrayList<searchMoviemodelclass>>
                        ) {
//                            adapter = response.body()?.let { searchAdapter(it) }!!
//                            binding!!.searchrecyler.adapter = adapter
                            val list = response.body()
                            if (list != null) {
                                arrlist = list

                                    adapter = searchAdapter(arrlist)
                              binding?.searchrecyler?.adapter = adapter
                            }



                            Log.d("btaokya", response.code().toString())


                        }
                        override fun onFailure(
                            call: Call<ArrayList<searchMoviemodelclass>>,
                            t: Throwable
                        ) {
                            Log.d("btaokya", "failure")
                        }

                    })
                return true
            }

        }
        )


        return binding?.root
    }
}

//    private fun filterList(query : String){
//        if(query != null){
//            val filteredList = ArrayList<searchMoviemodelclass>()
//            for(i in arrlist)
//            {
//                if(i.name.lowercase(Locale.ROOT).contains(query)){
//                    filteredList.add(i)
//                }
//            }
//            // passing filtered list to adapter class
//            if(filteredList.isEmpty()){
//                Toast.makeText(activity, "No Data Found", Toast.LENGTH_LONG).show()
//            }
//            else{
//                adapter.setFilteredList(filteredList)
//            }
//        }
//
//    }
//
//    private fun addDataToTheList() {
//        arrlist.add(searchMoviemodelclass("Avengers"))
//        arrlist.add(searchMoviemodelclass("Joker"))
//        arrlist.add(searchMoviemodelclass("Ra.one"))
//        arrlist.add(searchMoviemodelclass("Pk"))
//        arrlist.add(searchMoviemodelclass("Inseption"))
//        arrlist.add(searchMoviemodelclass("The Wailing "))
//        arrlist.add(searchMoviemodelclass("TiTanic"))
//        arrlist.add(searchMoviemodelclass("Kedarnath"))
//        arrlist.add(searchMoviemodelclass("Good Bye"))
//        arrlist.add(searchMoviemodelclass("My name is Khan"))
//        arrlist.add(searchMoviemodelclass("End"))
//        arrlist.add(searchMoviemodelclass("Lucy"))
//
//    }
//
//}

