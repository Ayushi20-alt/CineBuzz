package com.example.cinebuzz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class trendrecyclerAdapter(val context: Context, val arrayContact : ArrayList<homerecyler1card_data>) :
    RecyclerView.Adapter<trendrecyclerAdapter.MyviewHolder>() {

    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val img : ImageView = itemView.findViewById(R.id.recylertrendimage)
        val txt : TextView = itemView.findViewById(R.id.recylertrendtext)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): trendrecyclerAdapter.MyviewHolder {
        return trendrecyclerAdapter.MyviewHolder(
            LayoutInflater.from(context).inflate(R.layout.trendrecylercard, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return arrayContact.size
    }

    override fun onBindViewHolder(holder: trendrecyclerAdapter.MyviewHolder, position: Int) {
        holder.img.setImageResource(arrayContact[position].movieimg)
        holder.txt.setText(arrayContact[position].moviename)
    }
}