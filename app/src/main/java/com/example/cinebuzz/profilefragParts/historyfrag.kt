package com.example.cinebuzz.profilefragParts

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R
import com.example.cinebuzz.otherfiles.retrofitInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class historyfrag : Fragment() {
  private lateinit var recyclerView: RecyclerView
  private lateinit var textView: TextView
    @SuppressLint("MissingInflatedId", "UseRequireInsteadOfGet", "ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_historyfrag, container, false)


        recyclerView = view.findViewById(R.id.historyrecycler)
        recyclerView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL,false)

//        var arrList = ArrayList<wishlistcard_data>()
//        arrList.add(wishlistcard_data(R.drawable.movie10, "My Name is Khan"))
//        arrList.add(wishlistcard_data(R.drawable.movie12, "K.G.F"))
//        arrList.add(wishlistcard_data(R.drawable.movie13, "Raajneeti"))
//        arrList.add(wishlistcard_data(R.drawable.movie6, "Avengers"))
//        arrList.add(wishlistcard_data(R.drawable.movie8, "Pulp Fiction"))
//        arrList.add(wishlistcard_data(R.drawable.movie7, "Bad Times of Lyla"))
//        arrList.add(wishlistcard_data(R.drawable.movie10, "My Name is Khan"))
//        arrList.add(wishlistcard_data(R.drawable.movie12, "K.G.F"))
//        arrList.add(wishlistcard_data(R.drawable.movie13, "Raajneeti"))
//        arrList.add(wishlistcard_data(R.drawable.movie6, "Avengers"))
//        arrList.add(wishlistcard_data(R.drawable.movie8, "Pulp Fiction"))
//        arrList.add(wishlistcard_data(R.drawable.movie7, "Bad Times of Lyla"))

//        Toast.makeText(activity,"api called history", Toast.LENGTH_LONG).show()
        retrofitInstance.init().history().enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                if(response.isSuccessful())
                {
                    Toast.makeText(activity,"success history", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(activity,"failed more", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(activity,"failed",Toast.LENGTH_LONG).show()
            }
        })

       /* val recycleradapter = this.activity?.let { history_adapter(it, arrList) }
        recyclerView.adapter = recycleradapter*/

        // code for the dialoge box

        textView = view.findViewById(R.id.clear)
        textView.setOnClickListener {
//          val message : String = "Do you want to clear history?"
//            showCustomDialogBox(message)

            val dialogBinding = layoutInflater.inflate(R.layout.dialog_box,null)

            val myDialog = this.activity?.let { it1 -> Dialog(it1) }
            if (myDialog != null) {
                myDialog.setContentView(dialogBinding)
                myDialog.setCancelable(true)
                myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()

                val btn_cancel = dialogBinding.findViewById<Button>(R.id.materialButton2)
               btn_cancel.setOnClickListener {
                   var flag = true
                   myDialog.dismiss()
               }

                val btn_clear = dialogBinding.findViewById<Button>(R.id.materialButton3)
                btn_clear.setOnClickListener {
                    Toast.makeText(this.activity,"Cleared",Toast.LENGTH_LONG).show()
                }
            }

       }

        return view
    }



//    private fun showCustomDialogBox(message: String) {
//        val dialog = this.activity?.let { Dialog(it) }
//        if (dialog != null) {
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            dialog.setCancelable(false)
//            dialog.setContentView(R.layout.dialog_box)
//            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//            val tvmessage = view?.findViewById<TextView>(R.id.textView16)
//            val btn_cancel = view?.findViewById<Button>(R.id.materialButton2)
//            val btn_clear = view?.findViewById<Button>(R.id.materialButton3)
//
//            if (tvmessage != null) {
//                tvmessage.text= message
//            }
//
//            if (btn_clear != null) {
//                btn_clear.setOnClickListener {
//                    Toast.makeText(this.activity,"cleared",Toast.LENGTH_LONG).show()
//                }
//            }
//
//            if (btn_cancel != null) {
//                btn_cancel.setOnClickListener {
//                    dialog.dismiss()
//                }
//            }
//
//            dialog.show()
//        }
//
//    }


}