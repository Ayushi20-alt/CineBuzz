package com.example.cinebuzz.recycleradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R
import com.example.cinebuzz.homerecycler1card_data

class homerecycleradapter(val context: Context, val arrayContact: ArrayList<homerecycler1card_data>):RecyclerView.Adapter<homerecycleradapter.MyviewHolder>() {
    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.recyler1image)
        val txt: TextView = itemView.findViewById(R.id.recyler1text)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        return MyviewHolder(LayoutInflater.from(context).inflate(R.layout.homerecycler1card, parent ,false))
    }

    override fun getItemCount(): Int {
        return arrayContact.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.img.setImageResource(arrayContact[position].movieimg)
        holder.txt.text = arrayContact[position].moviename
    }

}

