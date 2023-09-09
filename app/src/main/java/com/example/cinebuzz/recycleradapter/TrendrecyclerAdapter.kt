package com.example.cinebuzz.recycleradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cinebuzz.R
import com.example.cinebuzz.dataclass.trendingmodelclassX

class trendrecyclerAdapter(val context: Context, val arrayContact: ArrayList<trendingmodelclassX>) :
    RecyclerView.Adapter<trendrecyclerAdapter.MyviewHolder>() {

    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val img : ImageView = itemView.findViewById(R.id.recylertrendimage)
        val txt : TextView = itemView.findViewById(R.id.recylertrendtext)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyviewHolder {
        return MyviewHolder(
            LayoutInflater.from(context).inflate(R.layout.trendrecylercard, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return arrayContact.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.img.load("https://cinebuzz.onrender.com/${arrayContact[position].poster}")
        holder.txt.text = arrayContact[position].name
    }
}